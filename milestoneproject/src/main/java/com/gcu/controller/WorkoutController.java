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

    @GetMapping("/workouts/add")
    public String showWorkoutLogPage(Model model) {
        model.addAttribute("workout", new Workout());
        return "workouts"; // workouts.html
    }

    @PostMapping("/workouts/add")
    public String processWorkoutLog(@ModelAttribute("workout") Workout workout, Model model) {
        String email = "user@example.com"; // Replace with actual logged-in user email
        String message = workoutService.logWorkout(email, workout);
        model.addAttribute("message", message);
        return "dashboard";
    }
}

// @GetMapping("/workouts/view")
// public String viewWorkouts(Model model, Principal principal) {
// if (principal == null) {
// model.addAttribute("message", "You must be logged in to view workouts.");
// return "dashboard";
// }

// Long userId = userRepository.findByUsername(principal.getName()).getId();
// model.addAttribute("workouts", workoutService.getAllWorkouts(userId));
// model.addAttribute("title", "View Workouts");
// return "viewWorkouts";
// }
