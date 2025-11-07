package com.gcu.business;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.WorkoutEntity;
import com.gcu.data.entity.repository.WorkoutRepository;
import com.gcu.model.Workout;

/**
 * Implementation of {@link WorkoutServiceInterface} that handles all workout
 * operations including logging, retrieving, updating, and deleting workouts.
 * <p>
 * This service acts as the bridge between the controller and the repository,
 * transforming model objects into entity objects for persistence.
 */
@Service
public class WorkoutService implements WorkoutServiceInterface {

    /**
     * Repository used to access workout records stored in the database.
     */
    @Autowired
    private WorkoutRepository workoutRepository;

    /**
     * Logs a new workout by converting the incoming model object into a database entity
     * and saving it through the repository.
     *
     * @param email   the email of the user logging the workout
     * @param workout the workout data submitted from the UI
     * @return a confirmation message indicating that the workout was successfully logged
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
     * Retrieves all workouts associated with a given user's email.
     *
     * @param email the user email used to filter workout records
     * @return a list of {@link WorkoutEntity} belonging to the user
     */
    @Override
    public List<WorkoutEntity> getWorkoutsByEmail(String email) {
        Iterable<WorkoutEntity> iterable = workoutRepository.findByEmail(email);
        List<WorkoutEntity> workouts = new ArrayList<>();
        iterable.forEach(workouts::add);
        return workouts;
    }

    /**
     * Retrieves a workout by ID and converts the entity into a DTO (model object).
     * Used when populating the Edit Workout form.
     *
     * @param id the ID of the workout being retrieved
     * @return a {@link Workout} model if found, otherwise {@code null}
     */
    @Override
    public Workout findById(Long id) {
        return workoutRepository.findById(id)
                .map(entity -> new Workout(
                        entity.getId(),
                        entity.getType(),
                        entity.getCaloriesBurned(),
                        entity.getDuration(),
                        entity.getEmail()
                ))
                .orElse(null);
    }

    /**
     * Updates an existing workout record in the database.
     * The incoming {@link Workout} is mapped to an existing {@link WorkoutEntity}.
     *
     * @param workout the updated workout model object submitted from the UI
     */
    @Override
    public void update(Workout workout) {
        WorkoutEntity existingWorkout = workoutRepository.findById(workout.getId()).orElse(null);

        if (existingWorkout != null) {
            existingWorkout.setType(workout.getType());
            existingWorkout.setCaloriesBurned(workout.getCaloriesBurned());
            existingWorkout.setDuration(workout.getDuration());
            existingWorkout.setEmail(workout.getEmail());
            workoutRepository.save(existingWorkout);

            System.out.println("Workout updated successfully: " + workout.getId());
        } else {
            System.out.println("Workout not found for update: " + workout.getId());
        }
    }

    /**
     * Deletes a workout record based on its ID.
     *
     * @param id the ID of the workout to delete
     */
    @Override
    public void delete(Long id) {
        workoutRepository.deleteById(id);
    }
}
