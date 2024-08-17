package com.example.techtask.repository;

import com.example.techtask.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT o.* FROM orders o " +
            "WHERE o.quantity > 1 " +
            "ORDER BY o.created_at DESC " +
            "LIMIT 1", nativeQuery = true)
    Order findNewestOrderWithMoreThanOneItem();

    @Query(value = "SELECT o.* FROM orders o " +
            "JOIN users u ON o.user_id = u.id " +
            "WHERE u.user_status = 'ACTIVE' " +
            "ORDER BY o.created_at", nativeQuery = true)
    List<Order> findOrdersByActiveUsersSortedByCreatedAt();

}
