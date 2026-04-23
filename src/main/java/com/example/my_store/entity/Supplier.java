//поставщик
package com.example.my_store.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contacts", nullable = false)
    private String contacts;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @OneToMany(mappedBy = "supplier")
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    public Supplier(){}

    public Long getId(){return id;}

    public String getContacts() {return contacts;}
    public void setContacts(String contacts) {this.contacts = contacts;}

    public String getCompanyName() {return companyName;}
    public void setCompanyName(String companyName) {this.companyName = companyName;}

    public List<PurchaseOrder> getPurchaseOrders() {return purchaseOrders;}
}
