// клиент
package com.example.my_store.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance", nullable = false) // долг
    private BigDecimal balance;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "telegram_id")
    private Long telegramId;

    @OneToMany(mappedBy = "customer")
    private List<Sale> sales = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<CustomerTransaction> customerTransactions = new ArrayList<>();

    public BigDecimal getBalance() {return balance;}
    public void setBalance(BigDecimal balance) {this.balance = balance;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}

    public Long getTelegramId() {return telegramId;}
    public void setTelegramId(Long telegramId) {this.telegramId = telegramId;}

    public Long getId() {return id;}

    public List<Sale> getSales(){return sales;}

    public List<CustomerTransaction> getCustomerTransactions() {return customerTransactions;}
}
