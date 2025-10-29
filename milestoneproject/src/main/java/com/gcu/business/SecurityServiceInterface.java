package com.gcu.business;

/**
 * Interface for user authentication services.
 */
public interface SecurityServiceInterface {

    /**
     * Authenticates a user based on username and password.
     *
     * @param username the username provided by the user
     * @param password the password provided by the user
     * @return true if authentication succeeds, false otherwise
     */
    boolean authenticate(String username, String password);
}
