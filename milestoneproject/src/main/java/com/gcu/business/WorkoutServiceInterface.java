package com.gcu.business;

import com.gcu.model.Workout;

/**
 * Interface for workout-related operations.
 */
public interface WorkoutServiceInterface {

    /**
     * Adds a workout.
     *
     * @param workout the Workout object containing type, calories, and duration
     * @return a message confirming the workout was added
     */
    String addWorkout(Workout workout);
}
