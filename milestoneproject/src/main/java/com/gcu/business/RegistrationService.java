package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.entity.repository.UserRepository;
import com.gcu.model.RegistrationForm;

@Service
public class RegistrationService implements RegistrationServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String registerUser(RegistrationForm form) {

        if (userRepository.findByUsername(form.getEmail()) != null) {
            return "This email is already registered. Please log in.";
        }

        UserEntity newUser = new UserEntity();
        newUser.setUsername(form.getEmail());
        newUser.setPassword(form.getPhoneNumber());

        userRepository.save(newUser);

        return "Registration successful! Please log in.";
    }
}
