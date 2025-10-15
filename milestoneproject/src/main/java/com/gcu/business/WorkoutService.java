package com.gcu.business;

import org.springframework.stereotype.Service;
import com.gcu.model.Workout;

@Service
public class WorkoutService implements WorkoutServiceInterface {

    @Override
    public String addWorkout(Workout workout) {
        // Simulate saving the workout (no database yet)
        System.out.println("Workout logged: " + workout.getType() + " for " + workout.getDuration() + " minutes.");
        return "Workout added: " + workout.getType() + " - " + workout.getDuration() + " minutes";
    }
}
