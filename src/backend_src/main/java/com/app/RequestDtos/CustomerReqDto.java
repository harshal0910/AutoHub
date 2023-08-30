package com.app.RequestDtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerReqDto {

	@Size(min=4)
	private String username;
	private String firstName;
	private String lastName;
	private String contact;
	@Email
	private String email;
	private String drivingLicenseNumber;
//	
//	
	private String creditCardDetails;
	private String address;
	
	
	
//	private String govId;
	@Size(min=8, max=30)
	private String password;
//	private String governmentIdNumber;
	

	
	
}
