package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;


    @GetMapping()
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        List<Whisky> foundWhisky = whiskyRepository.findAll();
        return new ResponseEntity<>(foundWhisky, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Whisky>>getWhisky(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/year")
    public ResponseEntity findByYear(@RequestParam(name = "year", required = false) Integer year){
        if (year != null){
            return new ResponseEntity(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/region")
    public ResponseEntity findByDistilleryRegion(@RequestParam(name = "region", required = false) String region){
        if (region != null){
            return new ResponseEntity(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/ad")
    public ResponseEntity findByAgeAndDistilleryName(
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "name", required = false) String name
    ){
        if ( age != null && name != null){
            return new ResponseEntity(whiskyRepository.findByAgeAndDistilleryName(age, name), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

}
