package com.example.mastery.orderservice.repository;


import com.example.mastery.orderservice.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
