package com.app.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
	
	boolean existsByVid(long id);

     List<Vehicle> findByLocationLocationId(long id);
	
	List<Vehicle> findByLocationCity(String city);
	
	Vehicle findByVid(long id);
	
}
