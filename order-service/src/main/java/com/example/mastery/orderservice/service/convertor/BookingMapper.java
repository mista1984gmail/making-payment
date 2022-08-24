package com.example.mastery.orderservice.service.convertor;

import com.example.mastery.orderservice.domain.Booking;
import com.example.mastery.orderservice.service.dto.BookingDto;
import com.example.mastery.orderservice.web.dto.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookingMapper {
    Booking dtoToModel(BookingDto bookingDto);
    BookingDto modelToDto(Booking booking);

    @Mapping(source = "bookingDto.orderDate", target = "orderDate")
    @Mapping(source = "bookingDto.code", target = "code")
    @Mapping(source = "bookingDto.status", target = "status")
    BookingResponse dtoToResponse(BookingDto bookingDto);
}
