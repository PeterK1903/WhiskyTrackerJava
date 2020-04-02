package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;


    @GetMapping()
    public ResponseEntity<List<Distillery>> getAllDistilleries(){
        List<Distillery> foundDistilleries = distilleryRepository.findAll();
        return new ResponseEntity<>(foundDistilleries, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Distillery>>getDistilleries(@PathVariable Long id){
        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/r")
    public ResponseEntity findByRegion(@RequestParam(name = "region", required = false) String region){
        if (region != null){
            return new ResponseEntity(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/wa")
    public ResponseEntity findByWhiskiesAge(@RequestParam(name = "age", required = false) Integer age){
        if (age != null){
            return new ResponseEntity(distilleryRepository.findByWhiskiesAge(age), HttpStatus.OK);
        }
        return new ResponseEntity(distilleryRepository.findAll(), HttpStatus.OK);
    }
    
}
