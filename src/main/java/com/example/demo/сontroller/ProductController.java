package com.example.demo.сontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        Product product = productRepository.findById(1).orElse(null);
        model.addAttribute("products",  product);
        return "products";
    }

    

}
