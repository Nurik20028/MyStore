package com.example.my_store.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.my_store.entity.enums.CustomertransactionType;

@Entity
@Table(name = "customer_transaction")
public class CustomerTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CustomertransactionType type;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    public CustomertransactionType getType() {return type;}
    public void setType(CustomertransactionType type) {this.type = type;}

    public BigDecimal getAmount() {return amount;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}

    public Sale getSale() {return sale;}
    public void setSale(Sale sale) {this.sale = sale;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}

    public Long getId() {return id;}
}
