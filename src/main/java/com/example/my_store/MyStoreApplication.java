package com.example.my_store;

import com.example.my_store.DTO.SaleItemDTO;
import com.example.my_store.entity.Product;
import com.example.my_store.repository.ProductRepository;
import com.example.my_store.service.SaleItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MyStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStoreApplication.class, args);
    }

}
