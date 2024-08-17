package com.example.techtask.service.impl;

import com.example.techtask.model.Order;
import com.example.techtask.repository.OrderRepository;
import com.example.techtask.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findOrder() {
        return orderRepository.findNewestOrderWithMoreThanOneItem();
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findOrdersByActiveUsersSortedByCreatedAt();
    }
}
