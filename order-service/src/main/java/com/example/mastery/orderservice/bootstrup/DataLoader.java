package com.example.mastery.orderservice.bootstrup;

import com.example.mastery.orderservice.domain.Category;
import com.example.mastery.orderservice.domain.Client;
import com.example.mastery.orderservice.domain.Product;
import com.example.mastery.orderservice.repository.ClientRepository;
import com.example.mastery.orderservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

//@Component
public class DataLoader {
    @Bean
    public CommandLineRunner loadData(ClientRepository clientRepository, ProductRepository productRepository) {
        return (args) -> {
            Set<Product> products = new HashSet<>();
            Product product1 = productRepository.save(new Product(1L, "sneakers", Category.SPORT, 99.99));
            products.add(product1);
            Product product2 = productRepository.save(new Product(2L, "shorts", Category.CLOTHES, 29.99));
            products.add(product2);

            clientRepository.save(new Client(1L, "Stas Mitskevich", "1234 5678 9012 3456"));

        };
    }
}
