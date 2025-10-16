package com.gcu.controller;

import com.gcu.business.WorkoutServiceInterface;
import com.gcu.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for handling workout-related pages and actions.
 */
@Controller
public class WorkoutController {

    private final WorkoutServiceInterface workoutService;

    /**
     * Constructor for dependency injection of WorkoutServiceInterface.
     *
     * @param workoutService the service for managing workouts
     */
    @Autowired
    public WorkoutController(WorkoutServiceInterface workoutService) {
        this.workoutService = workoutService;
    }

    /**
     * Displays the Add Workout form.
     *
     * @param model the Spring model for passing data to the view
     * @return the template name for adding a workout
     */
    @GetMapping("/workouts/add")
    public String showWorkoutForm(Model model) {
        model.addAttribute("workout", new Workout());
        model.addAttribute("title", "Add Workout");
        return "workouts";
    }

    /**
     * Processes the submitted workout form and logs the workout.
     *
     * @param workout the workout submitted by the user
     * @param model   the Spring model for passing data to the view
     * @return the dashboard template after adding the workout
     */
    @PostMapping("/workouts/add")
    public String addWorkout(@ModelAttribute Workout workout, Model model) {
        String message = workoutService.addWorkout(workout);
        model.addAttribute("message", message);
        model.addAttribute("title", "");
        return "dashboard";
    }
}
