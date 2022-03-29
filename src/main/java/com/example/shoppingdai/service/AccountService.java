package com.example.shoppingdai.service;

import com.example.shoppingdai.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AccountService {
    Page<Account> findAll(Pageable pageable);

    <S extends Account> S save(S entity);

    Optional<Account> findById(String s);
}
