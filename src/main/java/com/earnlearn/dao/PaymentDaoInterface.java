package com.earnlearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earnlearn.entity.Payment;

@Repository
public interface PaymentDaoInterface extends JpaRepository<Payment, Integer> {

}
