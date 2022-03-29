package com.example.shoppingdai.model;

import com.example.shoppingdai.entity.Product;
import com.example.shoppingdai.service.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SessionScope
@Data
public class Cart {
    @Autowired
    ProductService productService;

    public Map<Product, Integer> map = new HashMap<>();

    public Map<Product, Integer> getMap() {
		return map;
	}

	public void setMap(Map<Product, Integer> map) {
		this.map = map;
	}

	public void add(Integer id) {
        Product product = productService.findById(id).get();
        if (map.isEmpty()) {
            map.put(product, 1);
        } else {
            boolean flag = false;
            for (Map.Entry<Product, Integer> entry : map.entrySet()) {
                if (entry.getKey().getId() == id) {
                    entry.setValue(entry.getValue() + 1);
                    flag = true;
                }
            }
            if (!flag) {
                map.put(product, 1);
            }
        }
    }

    public void remove(Integer id) {
        Product product = productService.findById(id).get();
        map.remove(product);
    }

    public double amount(){
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
           total += (entry.getKey().getPrice() * entry.getValue());
        }
        return total;
    }
}
