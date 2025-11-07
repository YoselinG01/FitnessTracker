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
 * HomeController handles user authentication and dashboard navigation.
 * <p>
 * - Displays the login form
 * - Authenticates users
 * - Loads the dashboard with personalized data (user's first name)
 */
@Controller
@RequestMapping("/login")
public class HomeController {

    /**
     * Service used to authenticate the user login.
     */
    private final SecurityServiceInterface securityService;

    /**
     * Repository to retrieve user information from the database.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Constructor used to inject the authentication service.
     *
     * @param securityService authentication service implementation
     */
    @Autowired
    public HomeController(SecurityServiceInterface securityService) {
        this.securityService = securityService;
    }

    /**
     * Displays the login page.
     *
     * @param model holds attributes used to render the view
     * @return login.html template
     */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "POWER Login");
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    /**
     * Authenticates the user and routes them to the dashboard if successful.
     *
     * @param loginForm     login form data
     * @param bindingResult handles validation results
     * @param model         stores data for the view
     * @param session       holds user session information
     * @return dashboard.html if login valid, otherwise login.html
     */
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginForm loginForm, BindingResult bindingResult,
                          Model model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "POWER Login");
            return "login";
        }

        boolean isAuthenticated = securityService.authenticate(
                loginForm.getUsername(), loginForm.getPassword());

        if (isAuthenticated) {

            UserEntity user = userRepository.findByUsername(loginForm.getUsername());

            // Store user email in session
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

    /**
     * Displays the dashboard page on GET requests (used by Back to Dashboard button).
     * Retrieves the user's first name from the database using email stored in session.
     *
     * @param session holds the stored logged-in email
     * @param model   stores the user's name for display on dashboard
     * @return dashboard.html if session exists, otherwise redirects to login
     */
    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {

        // Retrieve stored email from session
        String email = (String) session.getAttribute("userEmail");

        if (email == null) {
            return "redirect:/login/"; // Prevent access if not logged in
        }

        // Retrieve user by email
        UserEntity user = userRepository.findByEmail(email);

        model.addAttribute("title", "POWER Dashboard");
        model.addAttribute("firstName", user.getFirstName());

        return "dashboard";
    }
}
