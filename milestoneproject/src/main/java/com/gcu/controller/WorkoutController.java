package com.gcu.controller;

import com.gcu.business.WorkoutServiceInterface;
import com.gcu.model.Workout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkoutController {

    private final WorkoutServiceInterface workoutService;

    @Autowired
    public WorkoutController(WorkoutServiceInterface workoutService) {
        this.workoutService = workoutService;
    }

    // Show the "Add Workout" page
    @GetMapping("/workouts")
    public String showWorkoutForm(Model model) {
        model.addAttribute("workout", new Workout());
        return "workouts"; // matches workouts.html
    }

    // Process the workout form
    @PostMapping("/workouts/add")
    public String addWorkout(@ModelAttribute Workout workout, Model model) {
        String message = workoutService.addWorkout(workout);
        model.addAttribute("message", message);
        return "dashboard"; // go back to dashboard after adding
    }
}
