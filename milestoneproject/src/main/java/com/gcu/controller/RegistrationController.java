package com.gcu.controller;

<<<<<<< HEAD
import com.gcu.model.RegistrationForm;
=======
import com.gcu.business.RegistrationServiceInterface;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.RegistrationForm;

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 65c71d28d09040ee5425774f8981be5b5d1afd69
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
<<<<<<< HEAD
 * RegistrationController is responsible for handling
 * requests related to the user registration process.
 *
 * It serves the registration page (GET request) and
 * processes form submissions (POST request).
=======
 * Handles user registration requests, including displaying
 * the registration form and processing form submissions.
>>>>>>> 65c71d28d09040ee5425774f8981be5b5d1afd69
 */
@Controller
public class RegistrationController {

    /**
<<<<<<< HEAD
     * Handles GET requests for the registration page.
     *
     * This method creates a new {@link RegistrationForm}
     * object and attaches it to the model so that the
     * registration form fields in the Thymeleaf template
     * can be bound automatically.
     *
     * @param model the model object used to pass data to the view
     * @return the name of the registration view (registration.html)
=======
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
>>>>>>> 65c71d28d09040ee5425774f8981be5b5d1afd69
     */
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration"; // matches registration.html
    }

    /**
<<<<<<< HEAD
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
=======
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
>>>>>>> 65c71d28d09040ee5425774f8981be5b5d1afd69
    }
}
