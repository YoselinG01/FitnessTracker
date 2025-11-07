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
     * Finds a user by their username (email).
     *
     * @param username the username to search for
     * @return the UserEntity with the given username, or null if not found
     */
    UserEntity findByUsername(String username);

}
