package com.gcu.data.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.data.entity.WorkoutEntity;

@Repository
public interface WorkoutRepository extends CrudRepository<WorkoutEntity, Long> {
    Iterable<WorkoutEntity> findByEmail(String email);
}
