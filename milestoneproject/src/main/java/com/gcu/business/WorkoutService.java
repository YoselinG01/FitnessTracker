package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.WorkoutEntity;
import com.gcu.data.entity.repository.WorkoutRepository;
import com.gcu.model.Workout;

@Service
public class WorkoutService implements WorkoutServiceInterface {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Override
    public String logWorkout(String email, Workout workout) {
        WorkoutEntity log = new WorkoutEntity();
        log.setEmail(email);
        log.setType(workout.getType());
        log.setDuration(workout.getDuration());
        log.setCaloriesBurned(workout.getCaloriesBurned());

        workoutRepository.save(log);

        return "Workout logged successfully!";
    }
}
