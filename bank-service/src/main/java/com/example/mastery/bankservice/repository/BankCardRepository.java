package com.example.mastery.bankservice.repository;

import com.example.mastery.bankservice.domain.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankCardRepository extends JpaRepository<BankCard, Long> {
    Optional<BankCard> findByCardNumber(String name);
}
