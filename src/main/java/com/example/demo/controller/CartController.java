package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class CartController {
    private final ProductService productService;
    private final CartService cartService;


    @Autowired
    private final ProductsRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public CartController(ProductService productService, CartService cartService, ProductsRepository productRepository, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.cartService = cartService;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/cart")
    public String home(@RequestParam(name = "category", required = false) Integer categoryId, @RequestParam(name = "search", required = false) String search, Model model) {

        Set<Integer> cartItems = cartService.getCartItemIds(); // Получаем товары из корзины
        List<Product> products = productRepository.findAllById(cartItems);

        model.addAttribute("products", products);

        model.addAttribute("cartCount", cartService.getTotalCount()); // Добавляем счётчик, если нужно
        return "cart";
    }
}
