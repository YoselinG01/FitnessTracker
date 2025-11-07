package com.gcu.controller;

import com.gcu.business.WorkoutServiceInterface;
import com.gcu.data.entity.WorkoutEntity;
import com.gcu.model.Workout;

import jakarta.servlet.http.HttpSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * WorkoutController handles all routes related to logging, viewing,
 * updating, and deleting workouts in the POWER Fitness Tracker application.
 * <p>
 * Each endpoint maps to a corresponding Thymeleaf view page and interacts
 * with the WorkoutService to read/write workout data from the database.
 */
@Controller
public class WorkoutController {

    /**
     * Service used to perform workout-related business logic and database access.
     */
    private final WorkoutServiceInterface workoutService;

    /**
     * Constructor for dependency injection of the WorkoutServiceInterface.
     *
     * @param workoutService the service used to perform workout operations
     */
    @Autowired
    public WorkoutController(WorkoutServiceInterface workoutService) {
        this.workoutService = workoutService;
    }

    /**
     * Displays the form used to add/log a new workout.
     *
     * @param model model used to pass a new Workout object to the view
     * @return "workouts" view (workouts.html)
     */
    @GetMapping("/workouts/add")
    public String showWorkoutLogPage(Model model) {
        model.addAttribute("workout", new Workout());
        return "workouts"; // workouts.html
    }

    /**
     * Handles form submission for adding/logging a workout.
     * Retrieves the logged-in user's email from the session, associates it
     * with the workout, and saves the workout through the service.
     *
     * @param workout the workout data submitted by the user
     * @param model   model used to pass success or error messages to the view
     * @param session session used to access the logged-in user's email
     * @return "dashboard" view after successfully logging a workout
     */
    @PostMapping("/workouts/add")
    public String processWorkoutLog(@ModelAttribute("workout") Workout workout, Model model, HttpSession session) {
        String email = (String) session.getAttribute("userEmail");
        String message = workoutService.logWorkout(email, workout);
        model.addAttribute("message", message);
        return "dashboard";
    }

    /**
     * Displays a list of all workouts associated with the logged-in user.
     *
     * @param model   model used to pass the workout list to the view
     * @param session session used to retrieve the logged-in user's email
     * @return "viewWorkouts" view showing all logged workouts (viewWorkouts.html)
     */
    @GetMapping("/workouts/view")
    public String viewWorkouts(Model model, HttpSession session) {
        String email = (String) session.getAttribute("userEmail");
        List<WorkoutEntity> workouts = workoutService.getWorkoutsByEmail(email);
        model.addAttribute("workouts", workouts);
        return "viewWorkouts";
    }

    /**
     * Displays the edit form for a specific workout based on its ID.
     *
     * @param id    the ID of the workout to edit
     * @param model model used to pass the selected workout to the view
     * @return "editWorkouts" view populated with the workout data (editWorkouts.html)
     */
    @GetMapping("/workouts/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Workout workout = workoutService.findById(id);
        model.addAttribute("workout", workout);
        return "editWorkouts";
    }

    /**
     * Processes the submission of an updated workout.
     *
     * @param workout the updated workout data
     * @return redirects the user back to the workout list view
     */
    @PostMapping("/workouts/update")
    public String updateWorkout(@ModelAttribute("workout") Workout workout) {
        workoutService.update(workout);
        return "redirect:/workouts/view";
    }

    /**
     * Deletes a workout based on its ID.
     *
     * @param id the ID of the workout to delete
     * @return redirects to the workout list view after deletion
     */
    @GetMapping("/workouts/delete/{id}")
    public String deleteWorkout(@PathVariable("id") Long id) {
        workoutService.delete(id);
        return "redirect:/workouts/view";
    }
}
