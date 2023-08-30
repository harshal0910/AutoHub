package com.app.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Repository.LocationRepo;
import com.app.Repository.VehicleRepo;
import com.app.RequestDtos.ApiResponse;
import com.app.RequestDtos.VehicleRequestDto;
import com.app.RespDtos.VehicleResponseDto;
import com.app.entities.Category;
import com.app.entities.Insurance;
import com.app.entities.Location;
import com.app.entities.Vehicle;
import com.app.exceptions.IncorrectDataException;
import com.app.exceptions.ResourceNotFoundException;
import com.app.services.InsuranceService;
import com.app.services.VehicleService;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleRepo VehicleRepo;
	
	@Autowired
	private LocationRepo locationRepo;
	
	@Autowired
	private InsuranceService insuranceServiceO;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public List<VehicleResponseDto> getAllVehicles() {
		// TODO Auto-generated method stub
		return VehicleRepo.findAll().stream().map(Vehicle -> VehicletoDto(Vehicle)).collect(Collectors.toList());
	}
    
	
	@Override
	public Vehicle addVehicle(VehicleRequestDto vehicleInfo) throws IncorrectDataException {
		
		if(!locationRepo.existsByCity(vehicleInfo.getCity())) {
			throw new IncorrectDataException("Wrong location!!");
		}
		Location location=locationRepo.findByCity(vehicleInfo.getCity()).get();
		Vehicle Vehicle=dtotoVehicle(vehicleInfo);
		Vehicle.setLocation(location);
		Long insuranceId=vehicleInfo.getInsurance();
		Insurance insurance= insuranceServiceO.getById(insuranceId);
		Vehicle.setInsurance(insurance);
		return this.VehicleRepo.save(Vehicle);
	}

	@Override
	public VehicleResponseDto findById(long id) {
		// TODO Auto-generated method stub
		if(this.VehicleRepo.existsById(id)) {
			return VehicletoDto(VehicleRepo.findById(id).get());
		}else {
			throw new ResourceNotFoundException("No Vehicle exists by this ID");
		}
	}

	@Override
	public Vehicle updateVehicle(long id, VehicleRequestDto VehicleInfo) throws IncorrectDataException {
		// TODO Auto-generated method stub
//		if(this.VehicleRepo.existsById(id)) {
//			Vehicle Vehicle=VehicleRepo.findById(id).get();
//			Vehicle=update(Vehicle, VehicleInfo);
//			Vehicle.setLocation(locationRepo.findByCity(VehicleInfo.getCity()).get());
//			return VehicleRepo.save(Vehicle);
//		}else {
//			throw new IncorrectDataException("Invalid Information");
//		}
		
		Optional<Vehicle> optionalVehicle = VehicleRepo.findById(id);
	    if (optionalVehicle.isPresent()) {
	        Vehicle vehicle = optionalVehicle.get();
	        // Update vehicle properties using vehicleRequestDto
	        vehicle=update(vehicle, VehicleInfo);
	        // Save the updated vehicle
	       return VehicleRepo.save(vehicle);
	        
	    } else {
	        throw new NoSuchElementException("Vehicle not found with id: " + id);
	    }
		
	    
	}
	
	@Override
	public ApiResponse deleteVehicle(long id) {
		String msg="Vehicle deletion failed!! ";
		if(VehicleRepo.existsById(id)) {
			Vehicle vehicle = VehicleRepo.findById(id).orElse(null);
	        if (vehicle != null) {
	            // Remove the insurance reference from the vehicle
	            vehicle.setInsurance(null);
	            VehicleRepo.deleteById(id);
				msg="Vehicle deleted!";;
	        }
			
		}else {
			throw new ResourceNotFoundException("No Vehicle exists by this Id");
		}
		return new ApiResponse(msg);
	}
	
	
	
	public Vehicle dtotoVehicle(VehicleRequestDto VehicleRequestDto)
	{
		Vehicle Vehicle=this.modelMapper.map(VehicleRequestDto, Vehicle.class);
		return Vehicle;
	}
	
	public VehicleResponseDto VehicletoDto(Vehicle Vehicle) {
		VehicleResponseDto VehicleResponseDto=this.modelMapper.map(Vehicle, VehicleResponseDto.class);
		return VehicleResponseDto;
	}
	
	public Vehicle update(Vehicle Vehicle, VehicleRequestDto VehicleRequestDto) {
		Vehicle.setBrand(VehicleRequestDto.getBrand());
		Vehicle.setModel(VehicleRequestDto.getModel());
		Vehicle.setCategory(Category.valueOf(VehicleRequestDto.getCategory()));
		Vehicle.setRate(VehicleRequestDto.getRate());
		return Vehicle;
	}


	@Override
	public List<VehicleResponseDto> findByCity(String city) throws IncorrectDataException {
		// TODO Auto-generated method stub
		if(locationRepo.existsByCity(city)) {
			return VehicleRepo.findByLocationCity(city).stream().map(Vehicle -> VehicletoDto(Vehicle)).collect(Collectors.toList());
		}
		else {
			throw new IncorrectDataException("Invalid City");
		}
	}


	@Override
	public List<VehicleResponseDto> findByLocationId(long id) {
		// TODO Auto-generated method stub
		return VehicleRepo.findByLocationLocationId(id).stream().map(Vehicle -> VehicletoDto(Vehicle)).collect(Collectors.toList());
	}


	

	

	
}
