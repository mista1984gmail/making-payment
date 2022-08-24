package com.example.mastery.bankservice.service.messaging.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankPaymentEvent {
    String status;
    String code;
}
