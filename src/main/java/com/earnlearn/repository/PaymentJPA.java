package com.earnlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earnlearn.entity.Payment;

@Repository
public interface PaymentJPA extends JpaRepository<Payment, Integer> {

}
