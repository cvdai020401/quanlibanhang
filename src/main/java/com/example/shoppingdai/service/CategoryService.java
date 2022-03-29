package com.example.shoppingdai.service;

import com.example.shoppingdai.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    <S extends Category> S save(S entity);

    void deleteById(Integer integer);
}
