package com.gcu.business;

import com.gcu.model.Workout;

public interface WorkoutServiceInterface {
    String logWorkout(String email, Workout workout);
}
