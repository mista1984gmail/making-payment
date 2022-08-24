package com.example.mastery.orderservice.web.controller;

import com.example.mastery.orderservice.service.BookingService;
import com.example.mastery.orderservice.service.convertor.BookingMapper;
import com.example.mastery.orderservice.service.dto.BookingDto;
import com.example.mastery.orderservice.web.dto.BookingResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/booking")
public class BookingController {

    private final BookingService bookingService;
    private final BookingMapper bookingMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponse save(@RequestBody BookingDto booking) {
        log.info("Save booking with code: {}", booking.getCode());
        return bookingMapper.dtoToResponse(bookingService.save(booking));
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public BookingResponse findByCode(@PathVariable  String code) {
        log.info("Find booking with code: {}", code);
        return bookingMapper.dtoToResponse(bookingService.findByCode(code));
    }
}
