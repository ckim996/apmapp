package com.ck.apmApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.User;
import com.ck.apmApp.models.UserPrincipal;
import com.ck.apmApp.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("User not found!");
		}
		return new UserPrincipal(user);
	}

}
