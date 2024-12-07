package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {
    private Map<Integer, Integer> cartItems = new HashMap<>();

    public void addToCart(int productId) {
        cartItems.put(productId, cartItems.getOrDefault(productId, 0) + 1);
    }

    public void removeFromCart(int productId) {
        if (cartItems.containsKey(productId)) {
            int currentQuantity = cartItems.get(productId);
            if (currentQuantity > 1) {
                cartItems.put(productId, currentQuantity - 1);
            } else {
                cartItems.remove(productId);
            }
        }
    }

    public int getTotalCount() {
        return cartItems.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getCountForProduct(int productId) {
        return cartItems.getOrDefault(productId, 0);
    }
}
