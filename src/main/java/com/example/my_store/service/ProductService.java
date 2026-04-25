package com.example.my_store.service;

import com.example.my_store.entity.Product;
import com.example.my_store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductByEanCode(String eanCode){
        return productRepository.findByEanCode(eanCode).orElseThrow(() -> new RuntimeException("Товар с кодом " + eanCode + " не найден!"));
    }


}
