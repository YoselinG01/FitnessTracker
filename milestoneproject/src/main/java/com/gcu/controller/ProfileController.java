package com.gcu.controller;

import com.gcu.business.ProfileServiceInterface;
import com.gcu.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ProfileController is responsible for handling all web requests
 * related to user profile creation and editing.
 *
 * <p>This controller interacts with the ProfileServiceInterface to
 * process profile data and forward information between the user
 * interface (Thymeleaf templates) and the business layer.</p>
 */
@Controller
public class ProfileController {

    private final ProfileServiceInterface profileService;

    /**
     * Constructor-based dependency injection for ProfileServiceInterface.
     *
     * @param profileService the service used for managing profile operations
     */
    @Autowired
    public ProfileController(ProfileServiceInterface profileService) {
        this.profileService = profileService;
    }

    /**
     * Displays the profile form where a user can add or edit their profile details.
     *
     * <p>This method initializes a new Profile object and adds it to the model
     * so that the Thymeleaf template can bind form inputs to it.</p>
     *
     * @param model the Spring model for passing data to the view
     * @return the name of the Thymeleaf template for editing a profile
     */
    @GetMapping("/profile/edit")
    public String showProfileForm(Model model) {
        model.addAttribute("profile", new Profile());
        model.addAttribute("title", "Profile");
        return "profile"; // points to profile.html
    }

    /**
     * Processes the submitted profile form and saves the profile information.
     *
     * <p>Delegates the business logic to ProfileServiceInterface to add
     * the profile, then returns the dashboard page with a confirmation message.</p>
     *
     * @param profile the Profile object submitted by the user through the form
     * @param model   the Spring model for passing data to the view
     * @return the name of the Thymeleaf template for the dashboard page
     */
    @PostMapping("/profile/edit")
    public String addProfile(@ModelAttribute Profile profile, Model model) {
        String message = profileService.addProfile(profile);
        model.addAttribute("message", message);
        model.addAttribute("title", "Dashboard");
        return "dashboard";
    }
}
