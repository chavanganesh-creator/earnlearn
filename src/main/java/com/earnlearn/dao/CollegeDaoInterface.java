package com.earnlearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rutuja Jadhav
 * Date 25-11-2021
 * 
 */

import org.springframework.stereotype.Repository;

import com.earnlearn.entity.College;

@Repository
public interface CollegeDaoInterface extends JpaRepository<College, Integer>{

}
