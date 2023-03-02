package com.haijie.workshop24.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.haijie.workshop24.model.Orders;
import static com.haijie.workshop24.repository.Queries.*;

@Repository
public class OrderRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean insertOrder(Orders ord){
        return jdbcTemplate.update(SQL_INSERT_ORDERS,
        ord.getCustomerName(),
        ord.getOrderDate(),
        ord.getShipAddress(),
        ord.getNotes(),
        ord.getTax())>0;
        // the >0 turns it to boolean
    }
}
