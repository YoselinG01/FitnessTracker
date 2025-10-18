package com.gcu.business;

import com.gcu.model.Profile;

/**
 * ProfileServiceInterface defines the contract for profile-related
 * operations within the application.
 *
 * <p>This interface should be implemented by service classes that
 * handle the creation, retrieval, updating, and deletion of user
 * profiles. It ensures a consistent structure for managing
 * profile functionality in the business layer.</p>
 */
public interface ProfileServiceInterface {

    /**
     * Adds a new profile to the system.
     *
     * @param profile The Profile object containing user details such as
     *                first name and last name.
     * @return A success message confirming that the profile was created.
     */
    String addProfile(Profile profile);
}
