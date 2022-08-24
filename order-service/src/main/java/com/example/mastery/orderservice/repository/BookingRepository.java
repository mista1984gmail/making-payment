package com.example.mastery.orderservice.repository;

import com.example.mastery.orderservice.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByCode(String code);
}
