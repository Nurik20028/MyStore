package com.example.my_store.DTO.response;
import java.math.BigDecimal;

public class ProductScanResponse {
    private Long productId;
    private String name;
    private BigDecimal price;

    // Конструктор
    public ProductScanResponse(Long productId, String name, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public ProductScanResponse() {
    }

    // Обязательно нужны геттеры, чтобы Spring (Jackson) смог превратить это в JSON
    public Long getProductId() { return productId; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }

    public void setProductId(Long productId) {this.productId = productId;}
    public void setName(String name) {this.name = name;}
    public void setPrice(BigDecimal price) {this.price = price;}
}
