package com.gcu.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utility class to generate a BCrypt hashed password from a plain text
 * password.
 * Can be run as a standalone program to print the hashed password.
 */
public class PasswordHasher {

    /**
     * Main method that hashes a plain text password and prints it.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "james"; // your plain text password
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}
