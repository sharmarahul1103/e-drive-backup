package com.Security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Security.Entity.UserInfo;
import com.Security.Repository.UserRepository;

@Service
public class UserInfoService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	public UserInfo findByUserName(String name)
	{
		return userRepository.findByusername(name);
	}
	
	public UserInfo addUser(UserInfo userInfo)
	{   userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		return userRepository.save(userInfo);
	}
	
	
	

}
