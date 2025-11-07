package com.gcu.data.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.data.entity.UserEntity;

/**
 * Repository for accessing and managing user data in the database.
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    /**
     * Finds a user by their username (login email).
     *
     * @param username the username entered on login
     * @return the UserEntity associated with the username
     */
    UserEntity findByUsername(String username);

    /**
     * Finds a user by their email address.
     * Used when displaying user info after login (dashboard, workouts, etc.)
     *
     * @param email the email stored in session
     * @return the UserEntity associated with the email
     */
    UserEntity findByEmail(String email);
}
