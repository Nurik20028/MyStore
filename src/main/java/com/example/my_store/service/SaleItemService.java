package com.example.my_store.service;

import com.example.my_store.DTO.SaleItemDTO;
import com.example.my_store.entity.Product;
import com.example.my_store.entity.SaleItem;
import com.example.my_store.repository.ProductRepository;
import com.example.my_store.repository.StockRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Service
public class SaleItemService {
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    public SaleItemService(StockRepository stockRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public SaleItem createSaleItem(SaleItem saleItem, Product product) {
        boolean isAll = false;
        saleItem.setCostPrice(product.getStock().getLastPurchasePrice());
        saleItem.setSellPrice(product.getStock().getSellingPrice());
        saleItem.setQuantity(BigDecimal.ONE);
        saleItem.setProduct(product);
        //sale -> saleItem эта связь уже создается в saleService

        return saleItem;
    }
}
