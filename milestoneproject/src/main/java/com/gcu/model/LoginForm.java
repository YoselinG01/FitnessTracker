package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents the data submitted by the user in the login form.
 */
public class LoginForm {

    /** Username entered by the user. */
    @NotNull(message = "User name is a required field")
    @Size(min = 1, max = 32, message = "User name must be between 1 and 32 characters")
    private String username;

    /** Password entered by the user. */
    @NotNull(message = "Password is a required field")
    @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
    private String password;

    /**
     * Returns the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
