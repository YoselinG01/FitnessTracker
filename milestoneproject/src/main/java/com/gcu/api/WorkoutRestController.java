package com.gcu.api;

import com.gcu.data.entity.WorkoutEntity;
import com.gcu.data.entity.repository.WorkoutRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing workout data in the POWER Fitness Tracker
 * application.
 * <p>
 * This controller exposes endpoints to retrieve all workouts or a specific
 * workout by its ID.
 * All endpoints are mapped under "/api/workouts" and require authentication.
 */
@RestController
@RequestMapping("/api/workouts")
public class WorkoutRestController {

    /**
     * Repository for accessing workout data in the database.
     */
    private final WorkoutRepository workoutRepository;

    /**
     * Constructor for dependency injection of the WorkoutRepository.
     *
     * @param workoutRepository repository used to access workout data
     */
    public WorkoutRestController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    /**
     * Retrieves a list of all workouts stored in the database.
     * <p>
     * This endpoint corresponds to GET /api/workouts.
     *
     * @return a list of all WorkoutEntity objects
     */
    @GetMapping
    public List<WorkoutEntity> getAllWorkouts() {
        return (List<WorkoutEntity>) workoutRepository.findAll();
    }

    /**
     * Retrieves a single workout by its unique ID.
     * <p>
     * This endpoint corresponds to GET /api/workouts/{id}.
     * If a workout with the given ID is not found, a 404 Not Found response is
     * returned.
     *
     * @param id the unique identifier of the workout to retrieve
     * @return ResponseEntity containing the WorkoutEntity if found, or 404 if not
     *         found
     */
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutEntity> getWorkoutById(@PathVariable Long id) {
        return workoutRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
