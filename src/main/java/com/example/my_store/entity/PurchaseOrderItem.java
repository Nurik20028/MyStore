//список заказа
package com.example.my_store.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "purchase_order_item")
public class PurchaseOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //цена за еденицу
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    // колличество
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //ссылка на заказ
    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;


    public BigDecimal getQuantity() {return quantity;}
    public void setQuantity(BigDecimal quantity) {this.quantity = quantity;}

    public BigDecimal getUnitPrice() {return unitPrice;}
    public void setUnitPrice(BigDecimal unitPrice) {this.unitPrice = unitPrice;}

    public Product getProduct() {return product;}
    public void setProduct(Product product) {this.product = product;}

    public PurchaseOrder getPurchaseOrder() {return purchaseOrder;}
    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {this.purchaseOrder = purchaseOrder;}

    public Long getId() {return id;}
}
