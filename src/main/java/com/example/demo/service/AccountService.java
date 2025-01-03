package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account getAccountByUsername(String username) {
        Optional<Account> account = accountRepository.findByUsername(username);
        return account.orElseThrow(() -> new RuntimeException("Account not found for username: " + username));
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
