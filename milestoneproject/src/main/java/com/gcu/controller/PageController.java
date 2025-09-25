package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Displays general pages like the register screen.
 */
@Controller
public class PageController {

    /**
     * Shows the register page.
     * 
     * @param model model for view data
     * @return register page
     */

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("title", "Register");
        return "register";
    }
}
