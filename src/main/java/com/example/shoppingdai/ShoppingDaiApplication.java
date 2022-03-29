package com.example.shoppingdai;

import com.example.shoppingdai.entity.Category;
import com.example.shoppingdai.entity.Product;
import com.example.shoppingdai.service.CategoryService;
import com.example.shoppingdai.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ShoppingDaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingDaiApplication.class, args);
    }

}
