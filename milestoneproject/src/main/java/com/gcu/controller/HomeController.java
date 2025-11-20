package com.gcu.controller;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.entity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/login")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Displays the login form (GET request).
     */
    @GetMapping("/")
    public String displayLogin(Model model) {
        model.addAttribute("title", "POWER Login");
        return "login";
    }

    /**
     * Displays the dashboard page.
     * Spring Security automatically provides the logged-in user's information.
     */
    @GetMapping("/dashboard")
    public String showDashboard(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/login/";
        }

        // Get username of logged in user from Spring Security
        String username = principal.getName();

        // Lookup user in database
        UserEntity user = userRepository.findByUsername(username);

        model.addAttribute("title", "POWER Dashboard");
        model.addAttribute("firstName", user.getFirstName());

        return "dashboard";
    }
}
