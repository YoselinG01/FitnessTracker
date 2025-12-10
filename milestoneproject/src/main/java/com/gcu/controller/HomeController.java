package com.gcu.controller;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.entity.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Controller that handles login and dashboard views.
 * Provides methods for displaying the login page and the user's dashboard.
 */
@Controller
@RequestMapping("/login")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Displays the login form page.
     *
     * @param model the Spring Model object to pass data to the view
     * @return the name of the login view (login.html)
     */
    @GetMapping("/")
    public String displayLogin(Model model) {
        model.addAttribute("title", "POWER Login");
        return "login";
    }

    /**
     * Displays the dashboard page for the logged-in user.
     *
     * @param model     the Spring Model object to pass data to the view
     * @param principal the currently authenticated user provided by Spring Security
     * @return the name of the dashboard view (dashboard.html), or redirects to
     *         login if not authenticated
     */
    @GetMapping("/dashboard")
    public String showDashboard(Model model, Principal principal, HttpSession session) {

        if (principal == null) {
            return "redirect:/login/";
        }

        // Get username of logged in user from Spring Security
        String username = principal.getName();

        // Lookup user in database
        UserEntity user = userRepository.findByUsername(username);
        session.setAttribute("userEmail", user.getEmail());

        model.addAttribute("title", "POWER Dashboard");
        model.addAttribute("firstName", user.getFirstName());

        return "dashboard";
    }
}
