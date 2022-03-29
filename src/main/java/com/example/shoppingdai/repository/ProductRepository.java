package com.example.shoppingdai.repository;

import com.example.shoppingdai.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.categoryId.id = ?1")
    public List<Product> getByCategory(Integer id);
}