package com.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Repository.InsuranceRepo;
import com.app.entities.Insurance;
import com.app.exceptions.ResourceNotFoundException;
import com.app.services.InsuranceService;

@Service
@Transactional
public class InsuranceServiceImpl implements InsuranceService {
	
	@Autowired
	private InsuranceRepo insuranceRepo;
	
	@Override
	public Insurance getById(Long id) {
		// TODO Auto-generated method stub
		return insuranceRepo.findById(id).orElseThrow(()->
			new ResourceNotFoundException("Invalid Insurance"));
	
	}

}
