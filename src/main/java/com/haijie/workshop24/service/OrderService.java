package com.haijie.workshop24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haijie.workshop24.repository.OrderDetailsRepo;
import com.haijie.workshop24.repository.OrderRepo;
import com.haijie.workshop24.exception.OrderException;
import com.haijie.workshop24.model.OrderResult;
import com.haijie.workshop24.model.Orders;

@Service
public class OrderService {

    @Autowired
    private OrderDetailsRepo odRepo;

    @Autowired
    private OrderRepo oRepo;

    @Transactional(rollbackFor = OrderException.class)
    public OrderResult createPurchaseOrder(Orders ord) throws OrderException{
        
        oRepo.insertOrder(ord);
        // check order > 3 throw exception
        if(ord.getOrderDetails().size() > 3){
            throw new OrderException();
        }
        odRepo.addOrderDetails(ord.getOrderDetails());
        OrderResult r =new OrderResult();
        return r;
    }
}
