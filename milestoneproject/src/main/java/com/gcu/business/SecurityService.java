package com.gcu.business;

import org.springframework.stereotype.Service;

@Service
public class SecurityService implements SecurityServiceInterface {

    @Override
    public boolean authenticate(String username, String password) {
        // Hardcoded (emulated) authentication
        return "admin".equals(username) && "123".equals(password);
    }
}
