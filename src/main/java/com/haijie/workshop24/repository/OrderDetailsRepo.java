package com.haijie.workshop24.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.haijie.workshop24.model.OrderDetails;
import static com.haijie.workshop24.repository.Queries.*;

@Repository
public class OrderDetailsRepo {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addOrderDetails(List<OrderDetails> orderDetailsItem){
        List<Object[]> arrData = orderDetailsItem.stream()
        .map(odi -> {
            Object[] i = new Object[4];
            i[0]=odi.getProduct();
            i[1]=odi.getUnitPrice();
            i[2]=odi.getDiscount();
            i[3]=odi.getQuantity();
            return i;
        }).toList();
        jdbcTemplate.batchUpdate(SQL_INSERT_ORDERDETAILS,arrData);
    }
}
