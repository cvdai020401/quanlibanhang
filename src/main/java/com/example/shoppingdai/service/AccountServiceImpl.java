package com.example.shoppingdai.service;

import com.example.shoppingdai.entity.Account;
import com.example.shoppingdai.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public <S extends Account> S save(S entity) {
        return accountRepository.save(entity);
    }

    @Override
    public Optional<Account> findById(String s) {
        return accountRepository.findById(s);
    }
}
