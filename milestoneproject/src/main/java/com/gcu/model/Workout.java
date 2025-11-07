package com.gcu.model;

/**
 * Represents a workout submitted by the user through the UI.
 * <p>
 * This model is used as a Data Transfer Object (DTO) for sending workout data
 * from the controller to the service layer and from the form input to the backend.
 * It does NOT directly map to the database — {@link com.gcu.data.entity.WorkoutEntity}
 * represents the actual database entity.
 */
public class Workout {

    /**
     * Unique identifier of the workout (used for editing or deleting existing workouts).
     */
    private Long id;

    /**
     * The type of workout performed (e.g., Running, Weightlifting, Cycling).
     */
    private String type;

    /**
     * Total calories burned during the workout session.
     */
    private int caloriesBurned;

    /**
     * Duration of the workout (measured in minutes).
     */
    private int duration;

    /**
     * Email address of the user who logged the workout.
     * Used to associate the workout with a specific account.
     */
    private String email;

    /**
     * Default constructor required for form binding and framework usage.
     */
    public Workout() {}

    /**
     * Constructs a new Workout model with all fields populated.
     *
     * @param id              unique identifier for the workout
     * @param type            type of workout (e.g., Running, Cycling)
     * @param caloriesBurned  total calories burned in the workout
     * @param duration        duration of the workout in minutes
     * @param email           email address of the user logging the workout
     */
    public Workout(Long id, String type, int caloriesBurned, int duration, String email) {
        this.id = id;
        this.type = type;
        this.caloriesBurned = caloriesBurned;
        this.duration = duration;
       	this.email = email;
    }

    /**
     * Gets the workout's unique identifier.
     *
     * @return workout ID
     */
    public Long getId() { return id; }

    /**
     * Sets the workout's unique identifier.
     *
     * @param id workout ID
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Gets the type of workout.
     *
     * @return workout type
     */
    public String getType() { return type; }

    /**
     * Sets the workout type.
     *
     * @param type workout type (e.g., Running, Cycling)
     */
    public void setType(String type) { this.type = type; }

    /**
     * Gets the total calories burned during the workout.
     *
     * @return calories burned
     */
    public int getCaloriesBurned() { return caloriesBurned; }

    /**
     * Sets the total calories burned for the workout.
     *
     * @param caloriesBurned calories burned
     */
    public void setCaloriesBurned(int caloriesBurned) { this.caloriesBurned = caloriesBurned; }

    /**
     * Gets the duration of the workout in minutes.
     *
     * @return workout duration
     */
    public int getDuration() { return duration; }

    /**
     * Sets the duration of the workout in minutes.
     *
     * @param duration workout duration
     */
    public void setDuration(int duration) { this.duration = duration; }

    /**
     * Gets the email of the user who logged the workout.
     *
     * @return user email
     */
    public String getEmail() { return email; }

    /**
     * Sets the email of the user who logged the workout.
     *
     * @param email user email
     */
    public void setEmail(String email) { this.email = email; }
}
