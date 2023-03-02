package com.haijie.workshop24.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderDetails {

    private Integer id;
    private Integer quantity;
    private String product;
    private String orderId;
    private BigDecimal unitPrice;
    private BigDecimal discount;

    public OrderDetails(){

    }

    public OrderDetails(String product, Integer quantity){
        this.product =product;
        this.quantity=quantity;
    }
    
    
}
