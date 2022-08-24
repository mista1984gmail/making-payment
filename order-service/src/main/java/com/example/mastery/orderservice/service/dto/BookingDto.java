package com.example.mastery.orderservice.service.dto;

import com.example.mastery.orderservice.domain.Client;
import com.example.mastery.orderservice.domain.Product;
import com.example.mastery.orderservice.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private LocalDate orderDate;
    private String code;
    private Status status;
    private Client client;
    private Set<Product> products;
}
