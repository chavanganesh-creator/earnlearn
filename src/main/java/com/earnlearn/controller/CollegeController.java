package com.earnlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.earnlearn.entity.College;
import com.earnlearn.serviceImpl.CollegeServiceInterface;


/**
 * 
 * @author Rutuja Jadhav
 * Date:25-11-2021
 * 
 */

@RestController
@RequestMapping("/college")
@CrossOrigin(origins = "http://localhost:4200")
public class CollegeController {
	
	@Autowired
	CollegeServiceInterface collegeServiceInterface;
	
	@PostMapping("/insertCollege")
	public College saveCollege(@RequestBody College college) {
		// TODO Auto-generated method stub
		College clg = collegeServiceInterface.savecollege(college);
		return clg;
	}
	
	@PutMapping("/updateCollege")
	public College updateCollege(@RequestBody College college)
	{
		College exitCollege = collegeServiceInterface.getById(college.getCid());
		college.setCreatedOn(exitCollege.getCreatedOn());
		College clg = collegeServiceInterface.updatecollege(college);
		return clg;
		
	}
	
	@DeleteMapping("/deleteCollege")
	public void deleteCollege(@RequestBody College college) {
		// TODO Auto-generated method stub
		collegeServiceInterface.deleteCollege(college);

	}
	
	@GetMapping("/getAllCollege")
	public List<College> getCollegeList() {
		return collegeServiceInterface.getCollegeList();
	}
	
	@GetMapping("/getCollegeById/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		// TODO Auto-generated method stub
		College college= collegeServiceInterface.getById(id);
		return new ResponseEntity<>(college,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable  int id) {
		// TODO Auto-generated method stub
		collegeServiceInterface.deleteById(id);
	}

	

}
