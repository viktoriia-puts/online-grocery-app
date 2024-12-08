package com.example.demo.сontroller;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;


@Controller
public class ProductController {

    private final ProductsService productService;
    private final CartService cartService;


    @Autowired
    private final ProductsRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductController(ProductsRepository productRepository, ProductsService productService, CartService cartService) {
        this.productRepository = productRepository;
        this.productService = productService;
        this.cartService = cartService;
    }

    //method will be called when http://localhost:8080 is requested
    @GetMapping("/")
    public String getAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        Set<Integer> cartItems = cartService.getCartItemIds();

        List<Category> categories = categoryRepository.findAll(); // Загружаем категории
        model.addAttribute("categories", categories);

        model.addAttribute("products", products);
        model.addAttribute("cartItems", cartItems); // Передаём идентификаторы товаров в корзине

        int totalCount = cartService.getTotalCount();
        model.addAttribute("cartCount", totalCount);

        return "products";
    }

    @GetMapping("/products")
    public String listProducts(@RequestParam(name = "category", required = false) Integer categoryId, Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<Product> products;

        if (categoryId != null) {
            products = productRepository.findByCategoryId(categoryId);
        } else {
            products = productRepository.findAll();
        }

        Set<Integer> cartItems = cartService.getCartItemIds(); // Получаем товары из корзины
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("cartItems", cartItems); // Добавляем в модель

        model.addAttribute("cartCount", cartService.getTotalCount()); // Добавляем счётчик, если нужно
        return "products";
    }

}
