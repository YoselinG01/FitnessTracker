package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Represents a workout record in the system and maps to the "workout" table.
 * Stores workout details linked to a specific user.
 */
@Table("workout")
public class WorkoutEntity {

    /** Unique identifier for the workout. */
    @Id
    private Long id;

    /** Email of the user who logged the workout. */
    private String email;

    /** Type of workout. */
    private String type;

    /** Duration of the workout in minutes. */
    private int duration;

    /** Calories burned during the workout. */
    @Column("calories_burned")
    private int caloriesBurned;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }
}
