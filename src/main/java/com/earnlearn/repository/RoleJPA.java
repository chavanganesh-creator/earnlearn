package com.earnlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earnlearn.entity.Role;
@Repository
public interface RoleJPA extends JpaRepository<Role, Integer> {

}
