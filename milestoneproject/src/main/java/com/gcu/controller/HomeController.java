package com.gcu.controller;

import com.gcu.model.LoginForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles login page and form submission.
 */
@Controller
@RequestMapping("/login")
public class HomeController {

    /**
     * Shows the login form.
     * 
     * @param model model for view data
     * @return login page
     */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "POWER Login");
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    /**
     * Processes login form.
     * 
     * @param loginForm     user input
     * @param bindingResult validation results
     * @param model         model for view data
     * @return dashboard or login page
     */
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginForm loginForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "POWER Login");
            return "login";
        }
        model.addAttribute("title", "POWER Dashboard");
        model.addAttribute("username", loginForm.getUsername());
        return "dashboard";
    }
}
