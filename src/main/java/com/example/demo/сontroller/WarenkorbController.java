package com.example.demo.сontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WarenkorbController {
    @GetMapping("/warenkorb")
    public String home() {
        return "warenkorb";
    }
}
