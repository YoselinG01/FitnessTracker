package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.WorkoutEntity;
import com.gcu.data.entity.repository.WorkoutRepository;
import com.gcu.model.Workout;

/**
 * Handles workout logging and retrieval operations.
 */
@Service
public class WorkoutService implements WorkoutServiceInterface {

    /**
     * Repository used to manage workout records.
     */
    @Autowired
    private WorkoutRepository workoutRepository;

    /**
     * Saves a new workout entry for the given user.
     *
     * @param email   the user's email
     * @param workout the workout details
     * @return a message confirming successful logging
     */
    @Override
    public String logWorkout(String email, Workout workout) {
        WorkoutEntity log = new WorkoutEntity();
        log.setEmail(email);
        log.setType(workout.getType());
        log.setDuration(workout.getDuration());
        log.setCaloriesBurned(workout.getCaloriesBurned());

        workoutRepository.save(log);

        return "Workout logged successfully!";
    }

    /**
     * Retrieves all workouts logged by a specific user.
     *
     * @param email the user's email
     * @return a list of workouts linked to the email
     */
    @Override
    public List<WorkoutEntity> getWorkoutsByEmail(String email) {
        Iterable<WorkoutEntity> iterable = workoutRepository.findByEmail(email);
        List<WorkoutEntity> workouts = new java.util.ArrayList<>();
        iterable.forEach(workouts::add);
        return workouts;
    }
}
