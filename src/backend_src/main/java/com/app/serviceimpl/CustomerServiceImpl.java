package com.app.serviceimpl;


import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.time.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import com.app.Repository.CustomerRepo;
import com.app.RequestDtos.CustomerReqDto;
import com.app.RequestDtos.LoginDto;
import com.app.RequestDtos.ReservationReqDto;
import com.app.RespDtos.CustomerRespDto;
import com.app.RespDtos.ReservationRespDto;
import com.app.entities.Customer;
import com.app.entities.Reservation;
import com.app.exceptions.ResourceNotFoundException;
import com.app.services.CustomerService;

@SuppressWarnings("unused")
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private ReservationRepo reservationRepo;
	
	@Autowired
	private ModelMapper modelMapper;


//	@Override
//	public UserRespDto authenticate(LoginDto loginInfo) {
//		// TODO Auto-generated method stub
//		Customeruser=this.userRepo.findByUsernameAndPassword(loginInfo.getUsername(), loginInfo.getPassword()).orElseThrow(()-> new ResourceNotFoundException("Incorrect username and password"));
//		return user;
//	}

	@Override
	public Optional<Customer> findByName(String Name) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return Optional.of(customerRepo.findByUsername(Name));
	}



	@Override
	public CustomerRespDto findByEmail(String email) {
		// TODO Auto-generated method stub
		return usertoDto(customerRepo.findByEmail(email).get());
	}

	@Override
	public ResponseEntity<Customer> registerCustomer(CustomerReqDto userinfo) {
		// TODO Auto-generated method stub
		System.out.println("check2");
		Customer user=dtoToUser(userinfo);
		System.out.println("check4"+user);
		String password=userinfo.getPassword();
		try {
			MessageDigest dutil =  MessageDigest.getInstance("SHA-256");
			String sha256hex = DigestUtils.sha256Hex(password);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setPassword(password);
	
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		customerRepo.save(user);
		
		return new ResponseEntity<Customer> (HttpStatus.CREATED);
	}

	@Override
	public CustomerRespDto authenticate(LoginDto loginInfo) {
		// TODO Auto-generated method stub
		String password=null;
		try {
			MessageDigest dutil =  MessageDigest.getInstance("SHA-256");
			String sha256hex = DigestUtils.sha256Hex(loginInfo.getPassword());
			password = sha256hex;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Customer customer= customerRepo.findByEmailAndPassword(loginInfo.getEmail(),password).get();
		return usertoDto(customer);
	}

	@Override
	public List<CustomerRespDto> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll().stream().map(customer-> usertoDto(customer)).collect(Collectors.toList());
	}

	@Override
	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub
		if(customerRepo.existsById(id)) {
			customerRepo.deleteById(id);
		}else {
			throw new ResourceNotFoundException("Customerwith this id doesn't exist!!");
		}
	}




	
	public CustomerRespDto usertoDto(Customer user) {
		CustomerRespDto userRespDto=this.modelMapper.map(user, CustomerRespDto.class);
		return userRespDto;
	}
	
	public Customer dtoToUser(CustomerReqDto customerReqDto) {
		System.out.println("check3");
		Customer user=this.modelMapper.map(customerReqDto, Customer.class);
		System.out.println("check5");
		return user;
	}

	public String update(String username, CustomerReqDto userReqDto) {
		String msg= "Customer updation failed";
		Customer user=customerRepo.findByUsername(username);
		if(user != null)
		{
		user.setEmail(userReqDto.getEmail());
		user.setUsername(userReqDto.getUsername());
		user.setPassword(userReqDto.getPassword());
		msg="Customer updted successfully";
		}
		return msg;
	}
	
	public Reservation dtotoReservation(ReservationReqDto reservationReqDto)
	{
		return this.modelMapper.map(reservationReqDto, Reservation.class);
	}
	
	public ReservationRespDto reservationToDto(Reservation reservation)
	{
		return this.modelMapper.map(reservation, ReservationRespDto.class);
	}
	
}
