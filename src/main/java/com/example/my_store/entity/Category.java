package com.example.my_store.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Long getId() {return id;}

    public List<Product> getProducts() {return products;}
}
