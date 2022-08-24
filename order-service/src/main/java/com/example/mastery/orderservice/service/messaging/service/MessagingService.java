package com.example.mastery.orderservice.service.messaging.service;

import com.example.mastery.orderservice.domain.Booking;
import com.example.mastery.orderservice.domain.Product;
import com.example.mastery.orderservice.domain.Status;
import com.example.mastery.orderservice.repository.BookingRepository;
import com.example.mastery.orderservice.service.dto.BookingDto;
import com.example.mastery.orderservice.service.messaging.event.BankPaymentEvent;
import com.example.mastery.orderservice.service.messaging.event.BookingEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessagingService {
    private final BookingRepository bookingRepository;
    private final KafkaSenderService kafkaSenderService;

    @KafkaListener(topics = "${messaging.topic.bank-payment}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public void setStatusBankingOperation(BankPaymentEvent bankPaymentEvent){
        var status = bankPaymentEvent.getStatus();
        var code = bankPaymentEvent.getCode();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var booking = bookingRepository.findByCode(code)
                .orElseThrow(()->new RuntimeException("Error: Booking is not found."));
        log.info("Find order with code: {}", booking.getCode());
        booking.setStatus(Status.valueOf(status));
        log.info("Set booking with code:{} status:{}",code, status);
        bookingRepository.save(booking);
        log.info("Save booking with code:{}", code);
    }

    public BookingDto setUpAndSendBooking(BookingDto booking) {
        booking.setStatus(Status.IN_PROCESS);
        booking.setOrderDate(LocalDate.now());
        var cardNumber = booking.getClient().getCardNumber();
        var price = booking.getProducts().stream().mapToDouble(Product::getPrice).sum();
        var code = UUID.randomUUID().toString();
        booking.setCode(code);
        kafkaSenderService.eventMakingPayment(new BookingEvent(cardNumber, price, code));
        log.info("Send bookingEvent: cardNumber:{}, booking code: {}", cardNumber, code);
        return booking;
    }

}
