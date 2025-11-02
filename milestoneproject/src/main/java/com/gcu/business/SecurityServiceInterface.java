package com.gcu.business;

/**
 * Defines the contract for user authentication services.
 */
public interface SecurityServiceInterface {

    /**
     * Checks if the provided username and password are valid.
     *
     * @param username the user's login name
     * @param password the user's password
     * @return true if the credentials are valid, false otherwise
     */
    boolean authenticate(String username, String password);
}
