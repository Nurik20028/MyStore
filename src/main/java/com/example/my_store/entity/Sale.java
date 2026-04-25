package com.example.my_store.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.my_store.entity.enums.SaleStatus;
import com.example.my_store.entity.enums.SalePaymentype;

@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SaleStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    private SalePaymentype paymentType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "sale")
    private List<CustomerTransaction> customerTransactions = new ArrayList<>();

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItem> saleItems = new ArrayList<>();

    public BigDecimal getTotalPrice() {return totalPrice;}
    public void setTotalPrice(BigDecimal totalPrice) {this.totalPrice = totalPrice;}

    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    public SaleStatus getStatus() {return status;}
    public void setStatus(SaleStatus status) {this.status = status;}

    public SalePaymentype getPaymentType() {return paymentType;}
    public void setPaymentType(SalePaymentype paymentType) {this.paymentType = paymentType;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}

    public Long getId() {return id;}

    public List<SaleItem> getSaleItems() {return saleItems;}

    public List<CustomerTransaction> getCustomerTransactions() {return customerTransactions;}


    public void addSaleItem(SaleItem saleItem){
        saleItems.add(saleItem);
        saleItem.setSale(this);
    }
    public void removeSaleItem(SaleItem saleItem){
        saleItems.remove(saleItem);
        saleItem.setSale(null);
    }
}
