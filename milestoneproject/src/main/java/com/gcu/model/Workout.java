package com.gcu.model;

public class Workout {
    private String type; // e.g., Cardio, Strength, Yoga
    private String description; // Description of the workout
    private int duration; // Duration in minutes

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
