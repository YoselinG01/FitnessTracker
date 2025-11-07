package com.gcu.data.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.data.entity.WorkoutEntity;

/**
 * Repository for accessing and managing workout records in the database.
 */
@Repository
public interface WorkoutRepository extends CrudRepository<WorkoutEntity, Long> {

    /**
     * Finds all workouts associated with a specific user's email.
     *
     * @param email the user's email
     * @return an iterable of WorkoutEntity objects for the user
     */
    Iterable<WorkoutEntity> findByEmail(String email);
}
