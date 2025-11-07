package com.gcu.business;

import java.util.List;

import com.gcu.data.entity.WorkoutEntity;
import com.gcu.model.Workout;

/**
 * Service interface that defines the operations for managing workout data.
 * <p>
 * This interface is implemented by the business service layer and used by the
 * controller to perform workout-related actions such as logging, retrieving,
 * updating, and deleting workouts.
 */
public interface WorkoutServiceInterface {

    /**
     * Logs a new workout for the specified user.
     *
     * @param email   the email of the user logging the workout
     * @param workout the workout details submitted from the UI
     * @return a confirmation message indicating whether logging was successful
     */
    String logWorkout(String email, Workout workout);

    /**
     * Retrieves all workouts that belong to a specific user based on their email.
     *
     * @param email the user's email used for filtering workout records
     * @return a list of {@link WorkoutEntity} associated with the user
     */
    List<WorkoutEntity> getWorkoutsByEmail(String email);

    /**
     * Retrieves a workout by its unique identifier.
     *
     * @param id the ID of the workout to retrieve
     * @return a {@link Workout} populated with data for editing or display
     */
    Workout findById(Long id);

    /**
     * Updates a workout record with new details.
     *
     * @param workout the updated workout data
     */
    void update(Workout workout);

    /**
     * Deletes a workout record from the system based on its ID.
     *
     * @param id the ID of the workout to delete
     */
    void delete(Long id);
}
