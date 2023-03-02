package com.haijie.workshop24.repository;

public class Queries {
    public static final String SQL_INSERT_ORDERS = """
            insert into orders(customer_name,order_date,ship_address,notes,tax)
            values (?,?,?,?,?)
            """;
    
    public static final String SQL_INSERT_ORDERDETAILS="""
            insert into order_details(product,unit_price,discount,quantity)
            values (?,?,?,?)
            """;
}
