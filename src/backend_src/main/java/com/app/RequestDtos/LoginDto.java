package com.app.RequestDtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class LoginDto {

	private String email;
	
	private String password;
}
