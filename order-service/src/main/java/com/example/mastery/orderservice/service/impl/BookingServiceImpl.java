package com.example.mastery.orderservice.service.impl;

import com.example.mastery.orderservice.domain.Booking;
import com.example.mastery.orderservice.repository.BookingRepository;
import com.example.mastery.orderservice.service.BookingService;
import com.example.mastery.orderservice.service.convertor.BookingMapper;
import com.example.mastery.orderservice.service.dto.BookingDto;
import com.example.mastery.orderservice.service.messaging.service.MessagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final MessagingService messagingService;
    private final BookingMapper bookingMapper;

    @Override
    public BookingDto save(BookingDto booking){
        var bookingForSave = messagingService.setUpAndSendBooking(booking);
        log.info("Save order with code:{} and status:{} ", booking.getCode(), booking.getStatus());
        return bookingMapper.modelToDto(bookingRepository.save(bookingMapper.dtoToModel(bookingForSave)));
    }

    @Override
    public BookingDto findByCode(String code) {
        log.info("Find order with code:{} ", code);
        return bookingMapper.modelToDto(bookingRepository.findByCode(code).get());
    }

}
