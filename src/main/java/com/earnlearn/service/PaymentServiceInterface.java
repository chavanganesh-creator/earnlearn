package com.earnlearn.service;

import java.util.List;

import com.earnlearn.entity.Payment;

public interface PaymentServiceInterface {
	
	public Payment savePayment(Payment payment);
	
	public Payment updatePayment(Payment payment);
	
	public void deletePaymentById(int id);
	
	public List<Payment> getAllPayment(Payment payment);
	
	public Payment getById(int id);

}
