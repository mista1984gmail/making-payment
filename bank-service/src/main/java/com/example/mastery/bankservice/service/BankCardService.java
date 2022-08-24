package com.example.mastery.bankservice.service;

import com.example.mastery.bankservice.domain.BankCard;

import java.util.Optional;

public interface BankCardService {
    BankCard save(BankCard bankCard);
    BankCard update(BankCard bankCard);
    Optional<BankCard> findByCardNumber(String cardNumber);
}
