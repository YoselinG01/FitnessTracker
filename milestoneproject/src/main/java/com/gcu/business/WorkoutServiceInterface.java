package com.gcu.business;

import java.util.List;

import com.gcu.data.entity.WorkoutEntity;
import com.gcu.model.Workout;

/**
 * Defines the methods for managing user workouts.
 */
public interface WorkoutServiceInterface {

    /**
     * Logs a new workout for the specified user.
     *
     * @param email   the user's email
     * @param workout the workout details
     * @return a message confirming if the workout was logged
     */
    String logWorkout(String email, Workout workout);

    /**
     * Gets all workouts associated with a user's email.
     *
     * @param email the user's email
     * @return a list of workout records
     */
    List<WorkoutEntity> getWorkoutsByEmail(String email);
}
