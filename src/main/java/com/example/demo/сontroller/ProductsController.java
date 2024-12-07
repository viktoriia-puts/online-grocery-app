package com.example.demo.сontroller;

import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductsService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;


@Controller
public class ProductsController {

    private final ProductsService productService;
    private final CartService cartService;


    @Autowired
    private final ProductsRepository productRepository;


    public ProductsController(ProductsRepository productRepository, ProductsService productService, CartService cartService) {
        this.productRepository = productRepository;
        this.productService = productService;
        this.cartService = cartService;
    }

    //method will be called when http://localhost:8080 is requested
    @GetMapping("/")
    public String getAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        Set<Integer> cartItems = cartService.getCartItemIds();
        model.addAttribute("products", products);
        model.addAttribute("cartItems", cartItems); // Передаём идентификаторы товаров в корзине
        return "products";
    }
}
