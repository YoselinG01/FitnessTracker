package com.gcu.business;

import com.gcu.model.RegistrationForm;

/**
 * Interface defining the contract for user registration services.
 */
public interface RegistrationServiceInterface {

    /**
     * Registers a new user using the provided registration form.
     *
     * @param form the registration form containing user information
     * @return a message indicating success or failure of registration
     */

    String registerUser(RegistrationForm form);
}
