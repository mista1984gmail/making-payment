package com.example.mastery.bankservice.service.messaging.service;

import com.example.mastery.bankservice.service.messaging.event.BankPaymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSenderService {
    @Value("${messaging.topic.bank-payment}")
    private String topicMakingPayment;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void eventBankPayment(BankPaymentEvent bankPaymentEvent) {
        this.kafkaTemplate.send(topicMakingPayment, bankPaymentEvent);
    }
}
