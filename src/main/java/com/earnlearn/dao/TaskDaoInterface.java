package com.earnlearn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earnlearn.entity.Task;
import com.earnlearn.entity.User;

@Repository
public interface TaskDaoInterface extends JpaRepository<Task, Integer> {

	List<Task> findAllByUsersOrderByStartDateAsc(User user);

	List<Task> findAllByOrderByStartDateAsc();

}
