package com.example.my_store.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_weight_based", nullable = false)
    private Boolean isWeightBased;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ean_code", nullable = true)
    private String eanCode;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<PurchaseOrderItem> purchaseOrderItems = new ArrayList<>();

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Stock stock;

    @OneToMany(mappedBy = "product")
    private List<SaleItem> saleItems = new ArrayList<>();

    public Boolean getWeightBased() {return isWeightBased;}
    public void setWeightBased(Boolean weightBased) {isWeightBased = weightBased;}

    public String getUnit() {return unit;}
    public void setUnit(String unit) {this.unit = unit;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEanCode() {return eanCode;}
    public void setEanCode(String eanCode) {this.eanCode = eanCode;}

    public Long getId() {return id;}

    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    public List<PurchaseOrderItem> getPurchaseOrderItems() {return purchaseOrderItems;}

    public Stock getStock() {return stock;}
    public void setStock(Stock stock) {
        if (stock != null) {
            stock.setProduct(this); // Автоматически привязываем Stock к этому Product
        }
        this.stock = stock;
    }

    public List<SaleItem> getSaleItems() {return saleItems;}
}
