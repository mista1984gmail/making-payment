package com.example.mastery.bankservice.service.messaging.service;

import com.example.mastery.bankservice.service.BankCardService;
import com.example.mastery.bankservice.service.messaging.event.BankPaymentEvent;
import com.example.mastery.bankservice.service.messaging.event.BookingEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
@AllArgsConstructor
public class MessagingService {
    private final static String APPROVED = "APPROVED";
    private final static String CANCELED = "CANCELED";
    private final BankCardService bankCardService;
    private final KafkaSenderService kafkaSenderService;

    @Transactional
    @KafkaListener(topics = "${messaging.topic.making-payment}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public void conductingBankingOperation(BookingEvent bookingEvent) {
        var cardNumber = bookingEvent.getCardNumber();
        var balance = bookingEvent.getPrice();
        var code = bookingEvent.getCode();
        var card = bankCardService.findByCardNumber(cardNumber).orElseThrow(() -> new RuntimeException("Error: Card is not found."));
        if (card.getBalance() > balance) {
            card.setBalance(card.getBalance() - balance);
            bankCardService.update(card);
            log.info("Booking with code: {} paid", code);
            kafkaSenderService.eventBankPayment(new BankPaymentEvent(APPROVED, code));
            log.info("Send event payment: {}", APPROVED);
        } else {
            kafkaSenderService.eventBankPayment(new BankPaymentEvent(CANCELED, code));
            log.info("Send event payment: {}", CANCELED);
        }
    }
}
