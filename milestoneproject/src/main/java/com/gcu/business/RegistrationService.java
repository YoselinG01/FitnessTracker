package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.entity.repository.UserRepository;
import com.gcu.model.RegistrationForm;

/**
 * Handles user registration logic and communication with the repository.
 */
@Service
public class RegistrationService implements RegistrationServiceInterface {

    /**
     * Repository used to manage user data.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Registers a new user if the email is not already in use.
     *
     * @param form The registration form containing user details.
     * @return A message indicating if registration was successful or not.
     */
    @Override
    public String registerUser(RegistrationForm form) {

        if (userRepository.findByUsername(form.getEmail()) != null) {
            return "This email is already registered. Please log in.";
        }

        UserEntity newUser = new UserEntity();
        newUser.setUsername(form.getEmail());
        newUser.setEmail(form.getEmail());
        newUser.setPassword(form.getPassword());
        newUser.setFirstName(form.getFirstName());
        newUser.setLastName(form.getLastName());
        newUser.setDateOfBirth(form.getDateOfBirth());
        newUser.setStreet1(form.getStreet1());
        newUser.setStreet2(form.getStreet2());
        newUser.setCity(form.getCity());
        newUser.setState(form.getState());
        newUser.setZip(form.getZip());
        newUser.setAreaCode(form.getAreaCode());
        newUser.setPhoneNumber(form.getPhoneNumber());

        userRepository.save(newUser);

        return "Registration successful! Please log in.";
    }
}
