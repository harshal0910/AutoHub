package com.app.RespDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRespDto {

	private long CustomerId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
}
