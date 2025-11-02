package com.gcu.controller;

import com.gcu.business.WorkoutServiceInterface;
import com.gcu.data.entity.WorkoutEntity;
import com.gcu.model.Workout;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles workout-related requests, including logging and viewing workouts.
 */
@Controller
public class WorkoutController {

    /**
     * Service for managing workouts.
     */
    private final WorkoutServiceInterface workoutService;

    /**
     * Constructor for dependency injection.
     *
     * @param workoutService the workout service
     */
    @Autowired
    public WorkoutController(WorkoutServiceInterface workoutService) {
        this.workoutService = workoutService;
    }

    /**
     * Displays the workout logging page with a new workout form.
     *
     * @param model the model for passing data to the view
     * @return the workout logging view
     */
    @GetMapping("/workouts/add")
    public String showWorkoutLogPage(Model model) {
        model.addAttribute("workout", new Workout());
        return "workouts"; // workouts.html
    }

    /**
     * Processes the submitted workout form and logs a new workout.
     *
     * @param workout the workout details submitted by the user
     * @param model   the model for passing data to the view
     * @param session the HTTP session containing user information
     * @return the dashboard view with a confirmation message
     */
    @PostMapping("/workouts/add")
    public String processWorkoutLog(@ModelAttribute("workout") Workout workout, Model model, HttpSession session) {
        // String email = "user@example.com"; // Replace with actual logged-in user
        // email
        String email = (String) session.getAttribute("userEmail");
        String message = workoutService.logWorkout(email, workout);
        model.addAttribute("message", message);
        return "dashboard";
    }

    /**
     * Displays all workouts logged by the current user.
     *
     * @param model   the model for passing data to the view
     * @param session the HTTP session containing user information
     * @return the viewWorkouts page showing all workouts
     */
    @GetMapping("/workouts/view")
    public String viewWorkouts(Model model, HttpSession session) {
        String email = (String) session.getAttribute("userEmail");
        List<WorkoutEntity> workouts = workoutService.getWorkoutsByEmail(email);
        model.addAttribute("workouts", workouts);
        return "viewWorkouts"; // viewWorkouts.html
    }
}
