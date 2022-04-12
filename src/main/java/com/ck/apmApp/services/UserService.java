package com.ck.apmApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.User;
import com.ck.apmApp.repositories.UserRepository;

@Service
public class UserService 
{
	@Autowired private BCryptPasswordEncoder encoder;
	@Autowired private UserRepository userRepository;
	
	public void save(User user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}
