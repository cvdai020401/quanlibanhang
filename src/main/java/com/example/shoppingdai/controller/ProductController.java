package com.example.shoppingdai.controller;

import com.example.shoppingdai.entity.Product;
import com.example.shoppingdai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public String home(@RequestParam("page") Optional<Integer> id,
                       Model model) {
        int pages = id.orElse(1);
        Pageable pageable = PageRequest.of(pages - 1, 6);
        Page<Product> productPage = productService.findAll(pageable);
        model.addAttribute("product", productPage);
        return "home";
    }

    @GetMapping("/products")
    public String getProduct(@RequestParam("category") Optional<Integer> id,
                             Model model){
        int category_id = id.orElse(1);
        List<Product> products =  productService.getByCategory(category_id);
        model.addAttribute("products", products);
        return "/product";
    }
}
