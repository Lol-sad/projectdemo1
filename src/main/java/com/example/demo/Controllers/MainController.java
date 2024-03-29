package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
       // System.out.println(5);
        return "home";
    }
    @PostMapping("/")
    public String homPage(Model model) {
        model.addAttribute("appName", appName);
        // System.out.println(5);
        return "home";
    }
}
