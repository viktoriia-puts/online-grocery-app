package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Register;
import com.example.demo.service.AccountService;
import com.example.demo.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private final RegisterService registerService;
    private final AccountService accountService;

    public RegisterController(RegisterService registerService, AccountService accountService) {
        this.registerService = registerService;
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

        Register register = new Register();
        register.setUsername(username);
        register.setEmail(email);
        register.setPassword(password);

        try {
            registerService.saveRegister(register);
        } catch (Exception e) {
        }

        // Создаём новый объект Account
        Account account = new Account();
        account.setUsername(register.getUsername());
        account.setEmail(register.getEmail());
        account.setPassword(register.getPassword());

        // Сохраняем account
        accountService.saveAccount(account);

        return "login";
    }

}
