package com.gcu.business;

public interface SecurityServiceInterface {
    boolean authenticate(String username, String password);
}
