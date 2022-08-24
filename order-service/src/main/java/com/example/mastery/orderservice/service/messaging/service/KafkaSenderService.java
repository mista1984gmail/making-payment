package com.example.mastery.orderservice.service.messaging.service;

import com.example.mastery.orderservice.service.messaging.event.BookingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSenderService {
    @Value("${messaging.topic.making-payment}")
    private String topicMakingPayment;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void eventMakingPayment(BookingEvent makingPaymentEvent) {
        this.kafkaTemplate.send(topicMakingPayment, makingPaymentEvent);
    }
}
