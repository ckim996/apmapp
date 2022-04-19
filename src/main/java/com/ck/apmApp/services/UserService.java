package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.User;
import com.ck.apmApp.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	// Returns a list of users
	public List<User> findAll() {
		return userRepository.findAll();
	}

	// get by id
	public User findById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
}
