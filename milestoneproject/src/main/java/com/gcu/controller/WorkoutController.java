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
    public String showWorkoutForm(Model model) {
        model.addAttribute("workout", new Workout());
        model.addAttribute("title", "Add Workout");
        return "workouts";
    }

    @PostMapping("/workouts/add")
    public String addWorkout(@ModelAttribute Workout workout, Model model) {
        String message = workoutService.addWorkout(workout);
        model.addAttribute("message", message);
        model.addAttribute("title", "");
        return "dashboard";
    }
}
