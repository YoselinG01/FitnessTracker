package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.entity.repository.UserRepository;

/**
 * Service class that implements Spring Security's UserDetailsService.
 * It loads user details from the database for authentication.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Default constructor.
     * <p>
     * Creates an instance of MyUserDetailsService.
     * </p>
     */
    public MyUserDetailsService() {
    }

    /**
     * Loads a user by username from the database.
     * 
     * @param username the username of the user trying to log in
     * @return UserDetails object containing username, password, and roles
     * @throws UsernameNotFoundException if the username is not found in the
     *                                   database
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword()) // hashed in DB
                .roles("USER")
                .build();
    }
}
