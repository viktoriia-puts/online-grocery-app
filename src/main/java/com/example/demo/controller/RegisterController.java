package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private final AccountService accountService;

    public RegisterController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public String home() {
        return "register";
    }

    @PostMapping("/register")
    public String processForm(@RequestParam String username,
                              @RequestParam String email,
                              @RequestParam String password) {

        // Создаём новый объект Account
        Account account = new Account();
        account.setUsername(username);
        account.setEmail(email);
        account.setPassword(password);

        // Сохраняем account
        accountService.saveAccount(account);

        return "login";
    }

}
