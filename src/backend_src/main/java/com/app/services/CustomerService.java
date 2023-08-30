package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.RequestDtos.CustomerReqDto;
import com.app.RequestDtos.LoginDto;
import com.app.RespDtos.CustomerRespDto;
import com.app.entities.Customer;
import com.app.exceptions.IncorrectDataException;


public interface CustomerService {

	Optional<Customer> findByName(String Name) throws IncorrectDataException;
	
	CustomerRespDto findByEmail(String email);
	
    ResponseEntity<Customer> registerCustomer(CustomerReqDto Customerinfo);

    CustomerRespDto authenticate(LoginDto loginInfo);
	
    String update(String username, CustomerReqDto userReqDto);
    
	List<CustomerRespDto> getAllCustomers();
	
	void deleteCustomer(long id);
	
//	void updateCustomer(CustomerReqDto Customerinfo, String Customername);
	
//	List<ReservationRespDto> getReservationCustomer(long id) throws IncorrectDataException;
	
}
