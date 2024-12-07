package com.example.demo.сontroller;

import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CartApiController {

    private final CartService cartService;

    @Autowired
    public CartApiController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addToCart")
    public Map<String, Integer> addToCart(@RequestParam("productId") int productId) {
        cartService.addToCart(productId);
        int totalCount = cartService.getTotalCount();
        return Collections.singletonMap("totalCount", totalCount);
    }

    @PostMapping("/removeFromCart")
    public Map<String, Integer> removeFromCart(@RequestParam("productId") int productId) {
        cartService.removeFromCart(productId);
        int totalCount = cartService.getTotalCount();
        return Collections.singletonMap("totalCount", totalCount);
    }
}
