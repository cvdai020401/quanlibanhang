package com.example.shoppingdai.controller;

import com.example.shoppingdai.entity.Account;
import com.example.shoppingdai.entity.Order;
import com.example.shoppingdai.entity.OrderDetail;
import com.example.shoppingdai.entity.Product;
import com.example.shoppingdai.model.Cart;
import com.example.shoppingdai.service.OrderDetailService;
import com.example.shoppingdai.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    HttpSession session;

    @Autowired
    HttpServletRequest request;

    @Autowired
    Cart cart;

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/order")
    public String order(Model model){
        Account account = (Account)session.getAttribute("user");

        List<Order> list = orderService.getOrderByUser(account.getId());
        model.addAttribute("list", list);
        return "order";
    }

    @PostMapping("/order/add")
    public String add(Model model){
        String address = request.getParameter("add");

        Account account = (Account) session.getAttribute("user");
        if(address.isEmpty()){
            return "redirect:/cart";
        }else{
            Order order = new Order();
            order.setUsername(account);
            order.setCreateDate(LocalDate.now());
            order.setAddress(address);

            order = orderService.save(order);

            Map<Product, Integer> map = cart.getMap();
            for(Map.Entry<Product, Integer> entry: map.entrySet()){
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(order);
                orderDetail.setProductId(entry.getKey());o
                orderDetail.setQuantity(entry.getValue());
                orderDetailService.save(orderDetail);
            }
            cart.setMap(new HashMap<>());
            return "redirect:/order";
        }
    }
}
