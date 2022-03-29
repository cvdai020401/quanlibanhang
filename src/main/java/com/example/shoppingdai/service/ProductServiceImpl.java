package com.example.shoppingdai.service;

import com.example.shoppingdai.entity.Product;
import com.example.shoppingdai.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public <S extends Product> S save(S entity) {
        return productRepository.save(entity);
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return productRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return productRepository.existsById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        productRepository.deleteById(integer);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Query("select p from Product p where p.categoryId.id = ?1")
    public List<Product> getByCategory(Integer id) {
        return productRepository.getByCategory(id);
    }
}
