package com.example.shoppingdai.controller;

import com.example.shoppingdai.entity.Product;
import com.example.shoppingdai.service.CategoryService;
import com.example.shoppingdai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin")
    public String admin(Model model,
                        @RequestParam("id")Optional<Integer> id){
       int productId = id.orElse(0);
        List<Product> list = productService.findAll();

        model.addAttribute("list", list);
        model.addAttribute("category", categoryService.findAll());
       if(productId == 0){
           model.addAttribute("product", new Product());
       }else{
           Product product = productService.findById(productId).get();
           model.addAttribute("product", product);

       }
        return "admin";
    }

    @PostMapping("/admin/add")
    public String add(@Validated @ModelAttribute("product") Product product,
                      BindingResult result,
                      Model model){
        if(result.hasErrors()){
            List<Product> list = productService.findAll();
            model.addAttribute("list", list);
            model.addAttribute("category", categoryService.findAll());
            return "admin";
        }else{
            productService.save(product);
            return "redirect:/admin";
        }

    }

    @PostMapping("/admin/edit")
    public String edit(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/admin";
    }
    @GetMapping("/admin/delete")
    public String delete(@RequestParam("id")Optional<Integer> id){
       int productId = id.orElse(0);
       if(productId != 0){
           Product product = productService.findById(productId).get();
           product.setAvaiable(false);
           productService.save(product);
       }
        return "redirect:/admin";
    }
}
