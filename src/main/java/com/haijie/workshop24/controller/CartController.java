package com.haijie.workshop24.controller;

import java.util.LinkedList;
import java.util.List;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haijie.workshop24.model.OrderDetails;
import com.haijie.workshop24.model.Orders;
import com.haijie.workshop24.model.OrderResult;
import com.haijie.workshop24.exception.OrderException;
import com.haijie.workshop24.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping(path="/")
public class CartController {

    @Autowired
    OrderService oSvc;

    @PostMapping("/cart")
    public String postOrder(@RequestBody MultiValueMap<String,String> form,
    Model model, HttpSession sess){

        List<OrderDetails> orderItems = (List<OrderDetails>)sess.getAttribute("cart");
        if(null == orderItems){
            orderItems = new LinkedList<>();
            sess.setAttribute("cart", orderItems);
        }
        String item=form.getFirst("item");
        Integer quantity = Integer.parseInt(form.getFirst("quantity"));
        orderItems.add(new OrderDetails(item,quantity));
        
        Orders ord = new Orders();
        ord.setCustomerName(form.getFirst("name"));
        ord.setOrderDetails(orderItems);

        sess.setAttribute("checkoutCart", ord);
        model.addAttribute("orderItems", orderItems);

        return "cart";
    }

    @PostMapping("/checkout")
    public String confirmCheckout(Model model, HttpSession sess)
        throws OrderException{
        List<OrderDetails> lineItems = (List<OrderDetails>)sess.getAttribute("cart");
        Orders ord = (Orders)sess.getAttribute("checkoutCart");
        OrderResult r = oSvc.createPurchaseOrder(ord);  
        sess.invalidate();
        model.addAttribute("total", lineItems.size());
        return "checkout";
    }
}
