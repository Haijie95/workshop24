package com.haijie.workshop24.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private String orderId;
    private Date orderDate;
    private String customerName;
    private String shipAddress;
    private String notes;
    private BigDecimal tax;
    private List<OrderDetails> orderDetails = new LinkedList<OrderDetails>();

    public void addOrderItems(OrderDetails i){
        this.orderDetails.add(i);
    }
}
