package com.gcu.business;

import com.gcu.model.Profile;
import org.springframework.stereotype.Service;

/**
 * ProfileService is a service layer class responsible for managing
 * profile-related operations such as creating and storing new profiles.
 * 
 * <p>This class implements the ProfileServiceInterface and provides
 * business logic for handling user profile information.</p>
 */
@Service
public class ProfileService implements ProfileServiceInterface {

    /**
     * Adds a new profile to the system.
     *
     * <p>Currently, this method simulates profile creation by returning
     * a success message containing the profile's first and last name.
     * In a real application, this would involve saving the profile to
     * a database.</p>
     *
     * @param profile The Profile object containing user details such as first name and last name.
     * @return A success message confirming that the profile was created.
     */
    @Override
    public String addProfile(Profile profile) {
        // For now, just return a success message
        return "Profile for " + profile.getFirstName() + " " + profile.getLastName() + " has been created successfully!";
    }
}
