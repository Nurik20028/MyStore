package com.example.my_store.service;

import com.example.my_store.DTO.SaleCreateDTO;
import com.example.my_store.entity.Product;
import com.example.my_store.entity.Sale;
import com.example.my_store.entity.SaleItem;
import com.example.my_store.entity.enums.SalePaymentype;
import com.example.my_store.entity.enums.SaleStatus;
import com.example.my_store.repository.CustomerRepository;
import com.example.my_store.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Service
public class SaleService {
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private SaleItemService saleItemService;
    private Scanner scanner = new Scanner(System.in);

    @Transactional
    public void createSale(SaleCreateDTO saleCreateDTO){
// создаем sale
        Sale sale = new Sale();
        sale.setCreatedAt(LocalDateTime.now());
        sale.setStatus(SaleStatus.CREATING);
        if(saleCreateDTO.getCustomerId() != null){ //привязываем пользователя
            sale.setCustomer(customerRepository.findById(saleCreateDTO.getCustomerId())
                    .orElseThrow(() -> new EntityNotFoundException("404 Customer not found with id: " + saleCreateDTO.getCustomerId()))); //вот эту часть я не понял
        }
        BigDecimal totalPrice = BigDecimal.ZERO;
        while(!saleCreateDTO.isReady()){ // создаем внутри много товаров для чека
            String productsCode = scanner.nextLine(); // берем eanCode товара
            Product product = productRepository.findByEanCode(productsCode)
                    .orElseThrow(() -> new EntityNotFoundException("404 Product not found with eanCode: " + productsCode)); //вот эту часть я не понял
            SaleItem saleItem = new SaleItem();
            saleItemService.createSaleItem(saleItem, product); // надо сейчас поработать с этим методом
            sale.addSaleItem(saleItem);
            totalPrice = totalPrice.add(saleItem.getSellPrice());
        }
        sale.setTotalPrice(totalPrice);
        sale.setPaymentType(SalePaymentype.QR); // надо потом добавить метод на случай если оплата будет наличкой, в долг или картой.
    }
}
