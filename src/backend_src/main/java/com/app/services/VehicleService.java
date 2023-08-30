package com.app.services;

import java.util.List;

import com.app.RequestDtos.ApiResponse;
import com.app.RequestDtos.VehicleRequestDto;
import com.app.RespDtos.VehicleResponseDto;
import com.app.entities.Vehicle;
import com.app.exceptions.IncorrectDataException;

public interface VehicleService {

	List<VehicleResponseDto> getAllVehicles();
	
    Vehicle addVehicle(VehicleRequestDto VehicleInfo) throws IncorrectDataException;
	
	VehicleResponseDto findById(long id);
	
	Vehicle updateVehicle(long id, VehicleRequestDto VehicleInfo) throws IncorrectDataException;
	
	ApiResponse deleteVehicle(long id);
	
	List<VehicleResponseDto> findByCity(String city) throws IncorrectDataException;
	

	List<VehicleResponseDto> findByLocationId(long id);
}
