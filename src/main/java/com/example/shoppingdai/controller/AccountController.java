package com.example.shoppingdai.controller;

import com.example.shoppingdai.Util.DtoUtil;
import com.example.shoppingdai.entity.Account;
import com.example.shoppingdai.model.Register;
import com.example.shoppingdai.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession httpSession;

    @Autowired
    DtoUtil dtoUtil;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/login")
    public String login2(@Validated @ModelAttribute("account") Account account,
                         BindingResult result){
       if(result.hasErrors()){
           return "login";
       }else{
           Account account1 = accountService.findById(account.getId()).orElse(null);
           if(account1 == null){
               return "redirect:/login";
           }else{
               if(account.getPassword().equals(account1.getPassword())){
                   if(account1.getAdmin()){
                       return "redirect:/admin";
                   }else{
                       httpSession.setAttribute("user", account1);
                       return "redirect:/home";
                   }
               }else{
                   return "redirect:/login";
               }
           }
       }
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("register", new Register());
        return "register";
    }

    @PostMapping("/register")
    public String register2(@Validated @ModelAttribute("register") Register register,
                            BindingResult result){
        if(result.hasErrors()){
            return "register";
        }else{
            Account account = dtoUtil.tranfer(register);
            accountService.save(account);
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        httpSession.removeAttribute("user");
        return "redirect:/login";
    }
}
