package com.app.services;

import com.app.RequestDtos.LoginDto;
import com.app.RespDtos.AdminRespDto;
import com.app.entities.Admin;

public interface AdminService {

	AdminRespDto authenticate(LoginDto loginInfo);
	
//	Admin createUser(String email, String password);
//	
//	boolean isUserValid(String email, String password);
}
