package com.example.shoppingdai.Util;

import com.example.shoppingdai.entity.Account;
import com.example.shoppingdai.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoUtil {
    @Autowired
    UploadUtil uploadUtil;

    public Account tranfer(Register register){
        Account account = new Account();
        account.setId(register.getUsername());
        account.setPassword(register.getPassword());
        account.setEmail(register.getEmail());
        account.setFullname(register.getName());
        if(register.getPhoto().getOriginalFilename().isEmpty()){
            account.setPhoto("");
        }else{
            account.setPhoto(uploadUtil.save(register.getPhoto(), "images"));
        }
        return account;
    }
}
