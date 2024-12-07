package com.example.demo.сontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CartApiController {

    private int productCount = 0;

    @PostMapping("/addToCart")
    public int addToCart() {
        productCount++;
        return productCount; // Возвращаем текущее количество после добавления
    }

    @GetMapping("/cartCount")
    public int getCartCount() {
        return productCount;
    }

    @PostMapping("/removeFromCart")
    public int removeFromCart() {
        if (productCount > 0) {
            productCount--;
        }
        return productCount;
    }
}
