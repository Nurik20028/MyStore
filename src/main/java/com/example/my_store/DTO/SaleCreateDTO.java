package com.example.my_store.DTO;

import com.example.my_store.entity.Product;
import com.example.my_store.entity.enums.SalePaymentype;

import java.math.BigDecimal;
import java.util.List;

public class SaleCreateDTO {
    private String eanCode;
    private Long customerId;
    private boolean isReady;

    public Long getCustomerId() {return customerId;}
    public boolean isReady() {return isReady;}
    public String getEanCode() {return eanCode;}
}
