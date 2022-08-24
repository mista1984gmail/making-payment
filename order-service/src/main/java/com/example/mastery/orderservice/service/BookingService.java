package com.example.mastery.orderservice.service;

import com.example.mastery.orderservice.service.dto.BookingDto;

public interface BookingService {
    BookingDto save(BookingDto bookingDto);

    BookingDto findByCode(String code);
}
