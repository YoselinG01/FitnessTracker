package com.gcu.controller;

import com.gcu.business.SecurityServiceInterface;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.entity.repository.UserRepository;
import com.gcu.model.LoginForm;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles login page display and form submission.
 */
@Controller
@RequestMapping("/login") // URL for controller
public class HomeController {

    /**
     * Service for user authentication.
     */
    private final SecurityServiceInterface securityService;

    /**
     * Repository for accessing user data.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Constructor for dependency injection.
     *
     * @param securityService the authentication service
     */
    @Autowired
    public HomeController(SecurityServiceInterface securityService) {
        this.securityService = securityService;
    }

    /**
     * Displays the login form.
     *
     * @param model model for passing data to the view
     * @return the login page
     */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "POWER Login");
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    /**
     * Processes the login form submission.
     *
     * @param loginForm     the login form with user input
     * @param bindingResult validation results
     * @param model         model for passing data to the view
     * @param session       HTTP session for storing user info
     * @return dashboard page if successful, login page if failed
     */
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginForm loginForm, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "POWER Login");
            return "login";
        }

        // Authenticate using the service
        boolean isAuthenticated = securityService.authenticate(
                loginForm.getUsername(), loginForm.getPassword());

        if (isAuthenticated) {

            UserEntity user = userRepository.findByUsername(loginForm.getUsername());
            session.setAttribute("userEmail", user.getEmail());

            model.addAttribute("title", "POWER Dashboard");
            model.addAttribute("firstName", user.getFirstName());
            return "dashboard";
        } else {
            model.addAttribute("title", "POWER Login");
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
