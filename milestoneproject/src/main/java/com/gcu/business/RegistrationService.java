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
