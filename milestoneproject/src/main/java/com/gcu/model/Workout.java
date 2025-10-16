package com.gcu.model;

public class Workout {
    private String type; // e.g., Cardio, Strength, Yoga
    private int caloriesBurned; // Calories burned during the workout
    private int duration; // Duration in minutes

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
