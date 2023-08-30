package com.app.services;

import java.util.List;

import com.app.RequestDtos.LocationRequestDto;
import com.app.RespDtos.LocationResponseDto;

public interface LocationService {
	
	LocationResponseDto findById(long id);
	
	LocationResponseDto findByCity(String city);
	
	List<LocationResponseDto> getAllLocations();
	
	void addLocation(LocationRequestDto locationRequestDto);
	
	void deleteByCity(String city);
	

}
