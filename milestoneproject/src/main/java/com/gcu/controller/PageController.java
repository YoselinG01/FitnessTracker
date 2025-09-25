package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // GET /register
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("title", "Register");
        return "register";
    }
}
