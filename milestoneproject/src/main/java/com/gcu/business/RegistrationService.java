package com.gcu.business;

import org.springframework.stereotype.Service;

import com.gcu.model.RegistrationForm;

/**
 * Service class that handles user registration logic
 */

@Service
public class RegistrationService implements RegistrationServiceInterface {

    /**
     * Registers a new user using the provided registration form.
     *
     * @param form the registration form containing user information
     * @return a message indicating success or failure of registration
     */

    @Override
    public String registerUser(RegistrationForm form) {
        // Simulated registration logic (no database)
        if (form.getFirstName() == null || form.getLastName() == null) {
            return "Registration failed. Missing information.";
        }

        System.out.println("New user registered: " + form.getFirstName() + " " + form.getLastName());
        return "Welcome " + form.getFirstName() + " " + form.getLastName() + "! Your account has been created.";
    }
}
