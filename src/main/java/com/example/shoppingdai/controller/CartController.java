package com.example.shoppingdai.controller;

import com.example.shoppingdai.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CartController {
    @Autowired
    Cart cart;

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("total", cart.amount());
        model.addAttribute("cart", cart.getMap());
        return "cart";
    }

    @GetMapping("/cart/add")
    public String addCart(@RequestParam("id")Optional<Integer> id,
                          Model model){
        Integer product_id = id.get();
        cart.add(product_id);

        return "redirect:/cart";
    }
}
