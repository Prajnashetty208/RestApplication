package com.order.message.service;

import com.order.message.model.Order;

import java.util.Set;

public interface OrderService {

    Order save(Order obj);
    Set<Order> findAll();
    Order findById(Long id);
    void deleteOrder(Long id);
}
