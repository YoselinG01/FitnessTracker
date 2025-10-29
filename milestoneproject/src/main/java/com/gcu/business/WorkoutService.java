package com.gcu.business;

import org.springframework.stereotype.Service;
import com.gcu.model.Workout;

/**
 * Service class for handling workout-related operations.
 */
@Service
public class WorkoutService implements WorkoutServiceInterface {

    /**
     * Adds a workout. Currently simulates saving without a database.
     *
     * @param workout the Workout object containing type, calories, and duration
     * @return a confirmation message indicating the workout was added
     */
    @Override
    public String addWorkout(Workout workout) {
        // Simulate saving the workout (no database yet)
        System.out.println("Workout logged: " + workout.getType() + " for " + workout.getDuration() + " minutes.");
        return "Workout added: " + workout.getType() + " - " + workout.getDuration() + " minutes";
    }
}
