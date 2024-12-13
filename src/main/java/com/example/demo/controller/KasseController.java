package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KasseController {
    @GetMapping("/kasse")
    public String home() {
        return "kasse";
    }

}
