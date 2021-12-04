package com.earnlearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earnlearn.entity.Role;
@Repository
public interface RoleDaoInterface extends JpaRepository<Role, Integer> {

}
