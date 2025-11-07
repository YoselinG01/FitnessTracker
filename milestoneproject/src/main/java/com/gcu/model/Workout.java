package com.gcu.model;

/**
 * Model class representing a Workout.
 */
public class Workout {
    private String type;
    private int caloriesBurned;
    private int duration;

    /**
     * Gets the type of the workout.
     *
     * @return the workout type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the workout.
     *
     * @param type the workout type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the calories burned during the workout.
     *
     * @return calories burned
     */
    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    /**
     * Sets the calories burned during the workout.
     *
     * @param caloriesBurned the calories burned
     */
    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    /**
     * Gets the duration of the workout in minutes.
     *
     * @return duration in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the workout in minutes.
     *
     * @param duration duration in minutes
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
