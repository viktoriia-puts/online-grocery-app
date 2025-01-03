package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.service.AccountService;
import com.example.demo.service.CartService;
import com.example.demo.service.KasseService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class KasseController {
    private final KasseService kasseService;
    private final CartService cartService;
    private final AccountService accountService;


    public KasseController(KasseService kasseService, CartService cartService, AccountService accountService) {
        this.kasseService = kasseService;
        this.cartService = cartService;
        this.accountService = accountService;
    }

    @GetMapping("/kasse")
    public String home() {
        return "kasse";
    }

    @PostMapping("/kasse")
    public String processForm(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String city,
                              @RequestParam String adress,
                              @RequestParam String telephone,
                              @RequestParam String state,
                              @RequestParam String zip,
                              Authentication authentication) {

        Order order = new Order();
        order.setFirstName(firstName);
        order.setLastName(lastName);
        order.setCity(city);
        order.setAdress(adress);
        order.setTelephone(telephone);
        order.setState(state);
        order.setZip(zip);

        // Проверяем, есть ли авторизованный пользователь
        if (authentication != null && authentication.isAuthenticated() &&
                !"anonymousUser".equals(authentication.getName())) {
            Account account = accountService.getAccountByUsername(authentication.getName());
            order.setAccount(account);
            order.setFirstName(account.getUsername());
        }

        for (Integer productId : cartService.getCartItemIds()) {
            Integer quantity = cartService.getCountForProduct(productId);

            OrderItem item = new OrderItem();
            item.setProductId(productId);
            item.setProductCount(quantity);
            item.setOrder(order);

            order.getOrderItems().add(item);
        }

        try {
            kasseService.saveOrder(order);
        } catch (Exception e) {
            return "error";
        }

        try {
            System.out.println("saveOrder");
            System.out.println(order.getFirstName());
        kasseService.saveOrder(order);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }
}
