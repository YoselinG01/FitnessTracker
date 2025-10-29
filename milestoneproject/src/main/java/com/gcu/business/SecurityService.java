package com.gcu.business;

import org.springframework.stereotype.Service;

/**
 * Service class for handling user authentication.
 */
@Service
public class SecurityService implements SecurityServiceInterface {

    /**
     * Authenticates a user using a hardcoded username and password.
     *
     * @param username the username provided by the user
     * @param password the password provided by the user
     * @return true if authentication is successful, false otherwise
     */
    @Override
    public boolean authenticate(String username, String password) {
        // Hardcoded (emulated) authentication
        return "admin".equals(username) && "123".equals(password);
    }
}
