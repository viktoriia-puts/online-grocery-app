package com.example.demo.сontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //method will be called when http://localhost:8080 is requested
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
