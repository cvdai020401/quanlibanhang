package com.example.shoppingdai.service;

import com.example.shoppingdai.entity.OrderDetail;

public interface OrderDetailService {
    <S extends OrderDetail> S save(S entity);

    void deleteById(Integer integer);
}
