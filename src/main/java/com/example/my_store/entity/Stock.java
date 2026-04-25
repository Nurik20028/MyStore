//я вроде закончил со всем что сверху сейчас не понимаю как настроить связь 1 : 1 product - stock;
package com.example.my_store.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    private Long id;

    @Column(name = "selling_price", nullable = false)
    private BigDecimal sellingPrice;

    @Column(name = "last_purchase_price", nullable = false)
    private BigDecimal lastPurchasePrice;

    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getLastPurchasePrice() {
        return lastPurchasePrice;
    }
    public void setLastPurchasePrice(BigDecimal lastPurchasePrice) {
        this.lastPurchasePrice = lastPurchasePrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {this.product = product;}

    public Long getId() {
        return id;
    }
}
