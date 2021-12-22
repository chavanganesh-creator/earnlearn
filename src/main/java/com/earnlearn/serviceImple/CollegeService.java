package com.earnlearn.serviceImple;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.earnlearn.repository.CollegeJPA;
import com.earnlearn.entity.College;
import com.earnlearn.service.CollegeServiceInterface;

/**
 * 
 * @author Rutuja Jadhav date 25-11-2021
 *
 */

@Service
public class CollegeService implements CollegeServiceInterface {

	@Autowired
    CollegeJPA collegeJPA;

	@Override
	public College savecollege(College college) {
		// TODO Auto-generated method stub
		college.setCreatedOn(new Date());
		college.setModifiedOn(new Date());
		College clg = collegeJPA.save(college);
		return clg;
	}

	@Override
	public College updatecollege(College college) {
		// TODO Auto-generated method stub
		college.setModifiedOn(new Date());
		College clg = collegeJPA.saveAndFlush(college);
		return clg;
	}

	@Override
	public void deleteCollege(College college) {
		// TODO Auto-generated method stub
		collegeJPA.delete(college);

	}

	@Override
	public List<College> getCollegeList() {
		// TODO Auto-generated method stub
		return collegeJPA.findAll();
	}

	@Override
	public College getById(int id) {
		// TODO Auto-generated method stub
		College response = null;
		Optional<College> collegeData = collegeJPA.findById(id);
		if (collegeData.isPresent()) {
			College Cdata = collegeData.get();
			response = Cdata;
		} else {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST," User Record Not Found");
		}
		return response;
	
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		collegeJPA.deleteById(id);

	}

}
