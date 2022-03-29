package com.example.shoppingdai.service;

import com.example.shoppingdai.entity.OrderDetail;
import com.example.shoppingdai.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public <S extends OrderDetail> S save(S entity) {
        return orderDetailRepository.save(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        orderDetailRepository.deleteById(integer);
    }
}
