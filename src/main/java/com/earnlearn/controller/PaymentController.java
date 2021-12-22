package com.earnlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.earnlearn.service.PaymentServiceInterface;
import com.earnlearn.entity.Payment;

@RestController
@RequestMapping("payment")
@CrossOrigin(origins = "https://earnlearn-dc60f.web.app")
public class PaymentController {

	@Autowired
	PaymentServiceInterface paymentServiceInterface;

	@PostMapping("/savePayment")
	public Payment savePayment(@RequestBody  Payment payment) {
		// TODO Auto-generated method stub
		return paymentServiceInterface.savePayment(payment);
	}

	@PutMapping("/updatePayment")
	public Payment updatePayment(@RequestBody  Payment payment) {
		// TODO Auto-generated method stub
		Payment pay =paymentServiceInterface.getById(payment.getId());
		payment.setModifiedOn(pay.getModifiedOn());
		return paymentServiceInterface.updatePayment(payment);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deletePaymentById(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		paymentServiceInterface.deletePaymentById(id);
	}

	@GetMapping("/getAllPayment")
	public List<Payment> getAllPayment(@RequestBody Payment payment) {
		// TODO Auto-generated method stub
		return paymentServiceInterface.getAllPayment(payment);
	}

	@GetMapping("/getById/{id}")
	public Payment getById(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		return paymentServiceInterface.getById(id);
	}

}
