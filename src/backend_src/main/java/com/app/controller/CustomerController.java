package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.RequestDtos.CustomerReqDto;
import com.app.RequestDtos.LoginDto;
import com.app.RequestDtos.ReservationReqDto;
import com.app.RespDtos.CustomerRespDto;
import com.app.services.CustomerService;
import com.app.services.ReservationService;
import com.app.services.VehicleService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private VehicleService vehicleService;
	
	public CustomerController() {
		System.out.println("in customer controller");
	}
	
	@PutMapping
	public ResponseEntity<?> updateCustomer(@RequestParam("userName") String username,@RequestBody CustomerReqDto customer)
	{
		return new ResponseEntity<>( customerService.update(username, customer),HttpStatus.OK);
		
	}

    @PostMapping("/booking")
    public ResponseEntity<?> createBooking(@RequestBody  ReservationReqDto reservationRequest)
    {    	
    	return new ResponseEntity<>(reservationService.createBooking(reservationRequest),HttpStatus.CREATED);
	
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerReqDto userinfo) {
       
        	System.out.println("check1"+userinfo);
            customerService.registerCustomer(userinfo);
            
            return new ResponseEntity<>("Customer registered successfully", HttpStatus.CREATED);
       
    }
    
    @PostMapping("/logincustomer")
    public ResponseEntity<CustomerRespDto> authenticatecustomer(@RequestBody LoginDto logindtls)
    {
    	CustomerRespDto loggedcustomer=customerService.authenticate(logindtls);
    	
    	return new ResponseEntity<CustomerRespDto>(loggedcustomer,HttpStatus.OK);
    }
}
