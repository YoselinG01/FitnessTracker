package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Model for login form input.
 */

public class LoginForm {

    /**
     * Username entered by the user.
     */
    @NotNull(message = "User name is a required field")
    @Size(min = 1, max = 32, message = "User name must be between 1 and 32 characters")
    private String username;

    /**
     * Password entered by the user.
     */
    @NotNull(message = "Password is a required field")
    @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
    private String password;

    /**
     * Gets the username
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * 
     * @param username the user's name
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * 
     * @param password the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
