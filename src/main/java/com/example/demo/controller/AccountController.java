package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/account")
    public String home(Model model, Authentication authentication) {

        if (authentication != null && authentication.isAuthenticated()) {
            Account account = accountService.getAccountByUsername(authentication.getName());
            model.addAttribute("account", account); // Добавляем весь объект Account
        }
        return "account";
    }
}
