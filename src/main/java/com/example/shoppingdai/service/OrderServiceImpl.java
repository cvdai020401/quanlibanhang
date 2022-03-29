package com.example.shoppingdai.service;

import com.example.shoppingdai.entity.Order;
import com.example.shoppingdai.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public <S extends Order> S save(S entity) {
        return orderRepository.save(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        orderRepository.deleteById(integer);
    }

    @Override
    @Query("select o from Order o where o.username.id  = ?1")
    public List<Order> getOrderByUser(String username) {
        return orderRepository.getOrderByUser(username);
    }
}
