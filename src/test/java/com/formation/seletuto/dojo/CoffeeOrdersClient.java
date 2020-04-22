package com.formation.seletuto.dojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoffeeOrdersClient {

    List<Order> orders = new ArrayList<>();

    public OrderReceipt placeOrder(long customerId, int quantity, String product){
        Order order = new Order(customerId, quantity, product);
        orders.add(order);
        return order.getReceipt();
    }

    public List<Order> getOrders(){
        return new ArrayList<>(orders);
    }

}
