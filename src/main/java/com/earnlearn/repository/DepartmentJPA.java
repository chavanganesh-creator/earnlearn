package com.earnlearn.repository;

/**
 * @author:Rutuja Jadhav
 * date-25/11/2021
 * department Repository
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earnlearn.entity.Department;

@Repository
public interface DepartmentJPA extends JpaRepository<Department, Integer>{

	




}
