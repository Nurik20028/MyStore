// чек
package com.example.my_store.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Table
@Entity
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cost_price") // цена закупки
    private BigDecimal costPrice;

    @Column(name = "selling_price") // цена продажи
    private BigDecimal sellPrice;

    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public BigDecimal getCostPrice() {return costPrice;}
    public void setCostPrice(BigDecimal costPrice) {this.costPrice = costPrice;}

    public BigDecimal getSellPrice() {return sellPrice;}
    public void setSellPrice(BigDecimal sellPrice) {this.sellPrice = sellPrice;}

    public BigDecimal getQuantity() {return quantity;}
    public void setQuantity(BigDecimal quantity) {this.quantity = quantity;}

    public Long getId() {return id;}

    public Product getProduct() {return product;}

    public Sale getSale() {return sale;}
}
