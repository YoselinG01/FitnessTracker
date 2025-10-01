package com.gcu.controller;

import com.gcu.model.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * RegistrationController is responsible for handling
 * requests related to the user registration process.
 *
 * It serves the registration page (GET request) and
 * processes form submissions (POST request).
 */
@Controller
public class RegistrationController {

    /**
     * Handles GET requests for the registration page.
     *
     * This method creates a new {@link RegistrationForm}
     * object and attaches it to the model so that the
     * registration form fields in the Thymeleaf template
     * can be bound automatically.
     *
     * @param model the model object used to pass data to the view
     * @return the name of the registration view (registration.html)
     */
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration"; // matches registration.html
    }

    /**
     * Handles POST requests for the registration form submission.
     *
     * When the user submits the registration form, Spring will
     * automatically bind the input fields to the
     * {@link RegistrationForm} object. The method then adds a
     * welcome message to the model and returns the dashboard view.
     *
     * @param form  the populated registration form submitted by the user
     * @param model the model object used to pass data to the view
     * @return the name of the dashboard view (dashboard.html)
     */
    @PostMapping("/register")
    public String processRegistration(@ModelAttribute RegistrationForm form, Model model) {
        model.addAttribute("message", "Welcome, "
                + form.getFirstName() + " " + form.getLastName()
                + "! Your account has been created.");
        return "dashboard"; // loads dashboard.html
    }
}
