package com.earnlearn.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earnlearn.entity.Payment;
import com.earnlearn.serviceImpl.PaymentServiceInterface;
import com.earnlearn.dao.PaymentDaoInterface;

@Service
public class PaymentService implements PaymentServiceInterface {

	@Autowired
	PaymentDaoInterface paymentDaoInterface;

	@Override
	public Payment savePayment(Payment payment) {
		// TODO Auto-generated method stub
		payment.setCreatedOn(new Date());
		payment.setModifiedOn(new Date());
		return paymentDaoInterface.save(payment);
	}

	@Override
	public Payment updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		payment.setModifiedOn(new Date());
		return paymentDaoInterface.saveAndFlush(payment);
	}

	@Override
	public void deletePaymentById(int id) {
		// TODO Auto-generated method stub
		paymentDaoInterface.deleteById(id);
	}

	@Override
	public List<Payment> getAllPayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentDaoInterface.findAll();
	}

	@Override
	public Payment getById(int id) {
		// TODO Auto-generated method stub
		return paymentDaoInterface.findById(id).get();
	}

}
