package com.gcu.controller;

import com.gcu.business.RegistrationServiceInterface;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.RegistrationForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles user registration requests, including displaying
 * the registration form and processing form submissions.
 */
@Controller
public class RegistrationController {

    /**
     * Service for managing user registration.
     */
    private final RegistrationServiceInterface registrationService;

    /**
     * Constructor for dependency injection.
     *
     * @param registrationService the registration service
     */
    @Autowired
    public RegistrationController(RegistrationServiceInterface registrationService) {
        this.registrationService = registrationService;
    }

    /**
     * Displays the registration page with a new registration form.
     *
     * @param model the model for passing data to the view
     * @return the registration view
     */
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration"; // matches registration.html
    }

    /**
     * Processes the submitted registration form and registers a new user.
     *
     * @param form  the registration form with user input
     * @param model the model for passing data to the view
     * @return the dashboard view with a registration message
     */
    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("registrationForm") RegistrationForm form, Model model) {
        String message = registrationService.registerUser(form);
        model.addAttribute("message", message);
        return "dashboard";
    }
}
