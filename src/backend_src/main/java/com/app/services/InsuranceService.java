package com.app.services;

import java.util.Optional;

import com.app.entities.Insurance;

public interface InsuranceService {
	
	Insurance getById(Long id);
}
