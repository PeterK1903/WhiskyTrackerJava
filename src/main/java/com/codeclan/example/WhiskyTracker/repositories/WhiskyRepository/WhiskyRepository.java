package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {


    // ToDo: Get all whiskey from a certain year.
    // What do I have: year
    // What do I want: List<Whiskey>

    List<Whisky> findByYear(int year);

    // ToDo: Get all whiskey from a particular distillery that is a specific age
    // What do I have: distillery + age
    // What do I want: List<Whiskey>

    List<Whisky> findByAgeAndDistilleryName(int age, String name);

    // ToDo: Get all whiskey from a particular region
    // What do I have: region
    // What do I want: List<Whiskey>

    List<Whisky> findByDistilleryRegion(String region);


}
