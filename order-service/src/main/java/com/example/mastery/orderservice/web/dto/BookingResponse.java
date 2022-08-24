package com.example.mastery.orderservice.web.dto;

import com.example.mastery.orderservice.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private LocalDate orderDate;
    private String code;
    private Status status;
}
