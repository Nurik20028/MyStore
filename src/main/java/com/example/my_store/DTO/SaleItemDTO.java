package com.example.my_store.DTO;

import java.math.BigDecimal;

public class SaleItemDTO {
    private Long productId;     // ID из базы
    private String name;        // Название (чтобы показать на экране)
    private BigDecimal price;   // Цена продажи (из таблицы ВНаличии)
    private double quantity;    // Количество (может быть 0.500 для весовых)
    private BigDecimal subTotal; // Итого за эту позицию (цена * кол-во)

    public SaleItemDTO(Long productId, String name, BigDecimal price, double quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.subTotal = price.multiply(BigDecimal.valueOf(quantity));
    }
    public void addQuantity(double amount) {
        this.quantity += amount;
        this.subTotal = this.price.multiply(BigDecimal.valueOf(this.quantity));
    }

    public Long getProductId() {return productId;}
    public String getName() {return name;}
    public BigDecimal getPrice() {return price;}
    public double getQuantity() {return quantity;}
    public BigDecimal getSubTotal() {return subTotal;}
}
