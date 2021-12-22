package com.earnlearn.service;

/**
 * @author Rutuja Jadhav
 * Date:25-11-2021
 * 
 */

import java.util.List;

import com.earnlearn.entity.College;

public interface CollegeServiceInterface {
	
	public College savecollege(College college);
	
	public College updatecollege(College college);
	
	public void deleteCollege(College college);
	
	public List<College> getCollegeList();

	public College getById(int id);
	
	public void deleteById(int id);
}
