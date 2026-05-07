package com.example.my_store.controller;

import com.example.my_store.DTO.response.ProductScanResponse;
import com.example.my_store.entity.Product;
import com.example.my_store.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/scan")
    public ResponseEntity<ProductScanResponse> scanProduct(@RequestParam("eanCode") String eanCode){
        ProductScanResponse response = productService.scanProduct(eanCode);
        return ResponseEntity.ok(response);
    }
}
