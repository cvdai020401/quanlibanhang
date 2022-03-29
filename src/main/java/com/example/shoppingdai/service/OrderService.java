package com.example.shoppingdai.service;

import com.example.shoppingdai.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderService {
    Page<Order> findAll(Pageable pageable);

    <S extends Order> S save(S entity);

    void deleteById(Integer integer);

    @Query("select o from Order o where o.username.id  = ?1")
    List<Order> getOrderByUser(String username);
}
