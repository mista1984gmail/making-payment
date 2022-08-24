package com.example.mastery.bankservice.service.impl;

import com.example.mastery.bankservice.domain.BankCard;
import com.example.mastery.bankservice.repository.BankCardRepository;
import com.example.mastery.bankservice.service.BankCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BankCardServiceImpl implements BankCardService {
    private final BankCardRepository bankCardRepository;

    @Override
    @Transactional
    public BankCard save(BankCard bankCard) {
        return bankCardRepository.save(bankCard);
    }

    @Override
    @Transactional
    public BankCard update(BankCard bankCard) {
        return bankCardRepository.save(bankCard);
    }

    @Override
    public Optional<BankCard> findByCardNumber(String cardNumber) {
        BankCard bankCard = bankCardRepository.findByCardNumber(cardNumber)
                .orElseThrow(() -> new RuntimeException("Error: Card is not found."));
        return Optional.ofNullable(bankCard);
    }

}
