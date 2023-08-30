package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.RequestDtos.LoginDto;
import com.app.RespDtos.AdminRespDto;
import com.app.entities.Admin;
import com.app.services.AdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	@Autowired
	private AdminService adminService; 
	public AdminController() {
		System.out.println("in admin controller");
	}
	
	@PostMapping("/login")
	public ResponseEntity<AdminRespDto> adminLogin(@RequestBody LoginDto logindtls)
	{
		AdminRespDto loggedadmin=adminService.authenticate(logindtls);
		
		return new ResponseEntity<AdminRespDto>(loggedadmin, HttpStatus.OK);
	}
	
//	@PostMapping
//	public ResponseEntity<?> createAdmin(@RequestBody Admin admin)
//	{
//		String email=admin.getEmail();
//		String pass=admin.getPassword();
//		adminService.createUser(email, pass);
//		
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
	

}
