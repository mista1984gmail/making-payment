package com.example.mastery.bankservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_card")
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="card_expiry_date")
    private LocalDate cardExpiryDate;
    @Column(name="card_number")
    private String cardNumber;
    @Column(name="balance")
    private Double balance;
}
