package com.app.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Repository.PaymentRepo;
import com.app.RespDtos.PaymentRespDto;
import com.app.entities.Payment;
import com.app.exceptions.ResourceNotFoundException;
import com.app.services.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepo paymentrepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public PaymentRespDto findByPaymentId(Long id) {
		if(this.paymentrepo.existsById(id)) {
			return paymentToDto(paymentrepo.findById(id).get());
		}else {
			throw new ResourceNotFoundException("No Vehicle exists by this ID");
		}
	}
	
	private PaymentRespDto paymentToDto(Payment payment) {
		PaymentRespDto paymentRespDto=this.modelMapper.map(payment, PaymentRespDto.class);
		return paymentRespDto;
	}

	@Override
	public List<Payment> findAllPayments() {
		// TODO Auto-generated method stub
		return paymentrepo.findAll();
	}

	@Override
	public List<Payment> findByAmount(double amount) {
		// TODO Auto-generated method stub
		return paymentrepo.findByAmount(amount);
	}
	
	


}
