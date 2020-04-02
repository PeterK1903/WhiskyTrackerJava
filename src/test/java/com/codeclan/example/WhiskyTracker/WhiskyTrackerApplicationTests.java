package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskeyByYear(){
		List<Whisky> foundWhisky = whiskyRepository.findByYear(1995);
	}

	@Test
	public void canFindDistilleriesByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Highland");
	}

	@Test
	public void canFindWhiskeyByAgeAndDistillery(){
		List<Whisky> foundWhisky = whiskyRepository.findByAgeAndDistilleryName(15, "Glendronach");
	}

	@Test
	public void canFindWhiskeyByDistilleryRegion(){
		List<Whisky> foundWhisky = whiskyRepository.findByDistilleryRegion("Highland");
	}

	@Test
	public void canFindDistilleriesByWhiskyAge(){
		List<Distillery> foundDistillery = distilleryRepository.findByWhiskiesAge(12);
	}

}
