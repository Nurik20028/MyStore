//заказ
package com.example.my_store.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.my_store.entity.enums.PurchaseorderStatus;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", nullable = false)
    private PurchaseorderStatus status;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "purchaseOrder")
    private List<PurchaseOrderItem> purchaseOrderItems = new ArrayList<>();

    public PurchaseorderStatus getStatus() {return status;}
    public void setStatus(PurchaseorderStatus status) {this.status = status;}

    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    public BigDecimal getTotalPrice() {return totalPrice;}
    public void setTotalPrice(BigDecimal totalPrice) {this.totalPrice = totalPrice;}

    public Long getId() {return id;}

    public Supplier getSupplier() {return supplier;}
    public void setSupplier(Supplier supplier) {this.supplier = supplier;}

    public List<PurchaseOrderItem> getPurchaseOrderItems() {return purchaseOrderItems;}


    public void addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem){
        purchaseOrderItems.add(purchaseOrderItem);
        purchaseOrderItem.setPurchaseOrder(this);
    }

    public void removePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem){
        purchaseOrderItems.remove(purchaseOrderItem);
        purchaseOrderItem.setPurchaseOrder(this);
    }
}
