package com.app.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.app.Repository.AdminRepo;
import com.app.RequestDtos.LoginDto;
import com.app.RespDtos.AdminRespDto;
import com.app.entities.Admin;
import com.app.services.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AdminRespDto authenticate(LoginDto loginInfo) {
		// TODO Auto-generated method stub
		System.out.println("admin dto" + loginInfo);
		Admin admin=adminRepo.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword()).get();
		System.out.println("admin "+ admin);
		return adminToDto(admin);
		
	}
	
	private AdminRespDto adminToDto(Admin admin) {
		AdminRespDto adminRespDto=this.modelMapper.map(admin, AdminRespDto.class);
		return adminRespDto;
	}
	
//	   @Override
//	    public Admin createUser(String email, String password) {
//		   Admin admin=adminRepo.findByEmail(email);
//	        admin.setPassword(passwordEncoder.encode(password));
//	        return adminRepo.save(admin);
//	    }
//
//	    @Override
//	    public boolean isUserValid(String email, String password) {
//	        Admin user = adminRepo.findByEmailAndPassword(email, password);
//	        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//	            return true; 
//	        }
//	        return false; 
//	    }

}
