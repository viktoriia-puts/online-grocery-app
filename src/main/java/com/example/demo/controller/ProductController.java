package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;


@Controller
public class ProductController {

    private final ProductService productService;
    private final CartService cartService;


    @Autowired
    private final ProductsRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductController(ProductsRepository productRepository, ProductService productService, CartService cartService) {
        this.productRepository = productRepository;
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping("/products")
    public String listProducts(@RequestParam(name = "category", required = false) Integer categoryId, @RequestParam(name = "search", required = false) String search, Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<Product> products;

        if (categoryId != null) {
            products = productRepository.findByCategoryId(categoryId);
        } else if (search != null && !search.trim().isEmpty()) {
            products = productRepository.findByNameContainingIgnoreCase(search.trim());
        } else {
            products = productRepository.findAll();
        }

        Set<Integer> cartItems = cartService.getCartItemIds();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("cartItems", cartItems);

        model.addAttribute("cartCount", cartService.getTotalCount());
        return "products";
    }

}
