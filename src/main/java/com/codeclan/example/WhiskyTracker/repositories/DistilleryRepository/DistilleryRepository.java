package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    // ToDo: Get all distilleries from a certain region
    // What do I have: region
    // What do I want: List<Distillery>

    List<Distillery> findByRegion(String region);

    // ToDo: Get all distilleries that have whiskys that are 12 years old
    // What do I have: whiskey age
    // What do I want: List<Distillery>

    List<Distillery> findByWhiskiesAge(int age);

}
