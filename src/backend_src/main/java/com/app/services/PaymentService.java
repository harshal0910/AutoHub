package com.app.services;

import java.util.List;

import com.app.RespDtos.PaymentRespDto;
import com.app.entities.Payment;

public interface PaymentService {

	//find by payment ID
	PaymentRespDto findByPaymentId(Long id);
	
	//find all payments
	List<Payment> findAllPayments();
	
	//find by amount
	List<Payment> findByAmount(double amount);
}
