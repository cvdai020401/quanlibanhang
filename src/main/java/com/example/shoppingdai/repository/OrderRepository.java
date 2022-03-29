package com.example.shoppingdai.repository;

import com.example.shoppingdai.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.username.id  = ?1")
    public List<Order> getOrderByUser(String username);
}