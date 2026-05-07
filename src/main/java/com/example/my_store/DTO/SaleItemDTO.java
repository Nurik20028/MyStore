package com.example.my_store.DTO;

import java.math.BigDecimal;

public class SaleItemDTO {
    private Long productId;     // ID из базы
    private String name;        // Название (чтобы показать на экране)
    private BigDecimal price;   // Цена продажи (из таблицы ВНаличии)
    private Boolean isRady;

    public SaleItemDTO(Long productId, String name, BigDecimal price, Boolean isRady) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.isRady = isRady;
    }

    public Long getProductId() {return productId;}
    public String getName() {return name;}
    public BigDecimal getPrice() {return price;}
    public Boolean getRady() {return isRady;}
}
