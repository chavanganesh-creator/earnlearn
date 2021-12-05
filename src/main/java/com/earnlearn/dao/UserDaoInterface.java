package com.earnlearn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earnlearn.entity.Role;
import com.earnlearn.entity.User;

@Repository
public interface UserDaoInterface extends JpaRepository<User, Integer> {

	List<User> findAllByRole(Role role);	

}
