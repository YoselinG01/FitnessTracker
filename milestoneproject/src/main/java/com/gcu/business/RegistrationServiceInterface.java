package com.gcu.business;

import com.gcu.data.entity.UserEntity;
import com.gcu.model.RegistrationForm;

/**
 * Defines the methods for user registration services.
 */
public interface RegistrationServiceInterface {

    /**
     * Creates a new user account with the given registration form details.
     *
     * @param form the form containing user registration data
     * @return a message showing if registration was successful or failed
     */

    String registerUser(RegistrationForm form);
}
