package com.example.demo.сontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.model.Products;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductsService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ProductsController {

    private final ProductsService productService;

    @Autowired
    private final ProductsRepository productRepository;


    public ProductsController(ProductsRepository productRepository, ProductsService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    //method will be called when http://localhost:8080 is requested
    @GetMapping("/")
    public String getAllProducts(Model model) {
        List<Products> products = productRepository.findAll();
        model.addAttribute("products",  products);
        return "products";
    }

    

}
