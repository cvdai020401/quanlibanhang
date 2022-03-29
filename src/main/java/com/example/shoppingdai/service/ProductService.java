package com.example.shoppingdai.service;

import com.example.shoppingdai.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    <S extends Product> S save(S entity);

    Optional<Product> findById(Integer integer);

    boolean existsById(Integer integer);

    void deleteById(Integer integer);

    List<Product> findAll();

    @Query("select p from Product p where p.categoryId.id = ?1")
    List<Product> getByCategory(Integer id);
}
