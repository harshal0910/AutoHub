package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Insurance;

public interface InsuranceRepo extends JpaRepository<Insurance, Long> {
	
	
}
