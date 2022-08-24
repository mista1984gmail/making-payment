package com.example.mastery.bankservice.bootstrup;

import com.example.mastery.bankservice.domain.BankCard;
import com.example.mastery.bankservice.repository.BankCardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class DataLoader {
    @Bean
    public CommandLineRunner loadDataClient(BankCardRepository bankCardRepository) {
        return (args) -> {
            bankCardRepository.save(new BankCard(1L, LocalDate.now().plusDays(365) , "1234 5678 9012 3456", 100.0));

        };
}
}
