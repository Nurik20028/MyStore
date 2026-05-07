// чек
package com.example.my_store.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Table(name = "sale_item")
@Entity
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cost_price") // цена закупки - наверное я это оставил для дальнейшего анализа продаж и покупок, на чеке это не отобразится
    private BigDecimal costPrice;

    @Column(name = "selling_price") // цена продажи
    private BigDecimal sellPrice;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    private boolean isRady;

    public BigDecimal getCostPrice() {return costPrice;}
    public void setCostPrice(BigDecimal costPrice) {this.costPrice = costPrice;}

    public BigDecimal getSellPrice() {return sellPrice;}
    public void setSellPrice(BigDecimal sellPrice) {this.sellPrice = sellPrice;}

    public BigDecimal getQuantity() {return quantity;}
    public void setQuantity(BigDecimal quantity) {this.quantity = quantity;}

    public Long getId() {return id;}

    public Product getProduct() {return product;}
    public void setProduct(Product product) {this.product = product;}

    public Sale getSale() {return sale;}
    public void setSale(Sale sale) {this.sale = sale;}

    public boolean isRady() {return isRady;}
    public void setRady(boolean rady) {isRady = rady;}
}
