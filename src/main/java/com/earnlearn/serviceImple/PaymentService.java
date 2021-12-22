package com.earnlearn.serviceImple;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earnlearn.entity.Payment;
import com.earnlearn.service.PaymentServiceInterface;
import com.earnlearn.repository.PaymentJPA;

@Service
public class PaymentService implements PaymentServiceInterface {

	@Autowired
    PaymentJPA paymentJPA;

	@Override
	public Payment savePayment(Payment payment) {
		// TODO Auto-generated method stub
		payment.setCreatedOn(new Date());
		payment.setModifiedOn(new Date());
		return paymentJPA.save(payment);
	}

	@Override
	public Payment updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		payment.setModifiedOn(new Date());
		return paymentJPA.saveAndFlush(payment);
	}

	@Override
	public void deletePaymentById(int id) {
		// TODO Auto-generated method stub
		paymentJPA.deleteById(id);
	}

	@Override
	public List<Payment> getAllPayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentJPA.findAll();
	}

	@Override
	public Payment getById(int id) {
		// TODO Auto-generated method stub
		return paymentJPA.findById(id).get();
	}

}
