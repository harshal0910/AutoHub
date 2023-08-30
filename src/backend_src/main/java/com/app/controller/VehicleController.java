package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.RequestDtos.VehicleRequestDto;
import com.app.RespDtos.VehicleResponseDto;
import com.app.entities.Vehicle;
import com.app.exceptions.IncorrectDataException;
import com.app.services.VehicleService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "http://localhost:3000")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<VehicleResponseDto>> getAllVehicles(){
		return new ResponseEntity<>(vehicleService.getAllVehicles(),HttpStatus.OK);
	}
	
	@GetMapping("/getById/{vid}")
	public ResponseEntity<VehicleResponseDto> getVehicleById(@PathVariable long vid){
		return new ResponseEntity<>(vehicleService.findById(vid),HttpStatus.OK);
	}
	
	
	@PostMapping("/addvehicle")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleRequestDto vehicleRequestDto) throws IncorrectDataException{
		System.out.println(vehicleRequestDto);
		return new ResponseEntity<Vehicle>(vehicleService.addVehicle(vehicleRequestDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateVehicle")
	public ResponseEntity<?> editVehicle(@RequestParam("id") Long id,@RequestBody VehicleRequestDto vehicleRequestDto) throws IncorrectDataException{
		vehicleService.updateVehicle(id, vehicleRequestDto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteVehicle")
	public ResponseEntity<?> deleteVehicle(@RequestParam("id") Long id){
		
		vehicleService.deleteVehicle(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
