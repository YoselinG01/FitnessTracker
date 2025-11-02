package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.entity.repository.UserRepository;

/**
 * Handles user authentication by checking login credentials.
 */
@Service
public class SecurityService implements SecurityServiceInterface {

    /**
     * Repository used to access user information.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Verifies if the given username and password match an existing user.
     *
     * @param username the user's login name
     * @param password the user's password
     * @return true if authentication is successful, false otherwise
     */
    @Override
    public boolean authenticate(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
