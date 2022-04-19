package com.ck.apmApp.security.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.User;
import com.ck.apmApp.repositories.UserRepository;
import com.ck.apmApp.security.models.Role;
import com.ck.apmApp.security.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	// Returns a list of roles
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	// Save new role
	public void save(Role role) {
		roleRepository.save(role);
	}

	// get by id
	public Optional<Role> findById(Integer id) {
		return roleRepository.findById(id);
	}

	public void delete(Integer id) {
		roleRepository.deleteById(id);
	}
	
	public void assignUserRole(Integer userId, Integer roleId)
	{
		User user = userRepository.findById(userId).orElse(null);
		Role role = roleRepository.findById(roleId).orElse(null);
		Set<Role> userRole = user.getRoles();
		userRole.add(role);
		user.setRoles(userRole);
		userRepository.save(user);
	}
	
	public void unassignUserRole(Integer userId, Integer roleId)
	{
		User user = userRepository.findById(userId).orElse(null);
		Set<Role> userRoles = user.getRoles();
		userRoles.removeIf(x -> x.getId()==roleId);
		userRepository.save(user);
	}
	
	public Set<Role> getUserRoles(User user)
	{
		return user.getRoles();
	}
	
	public Set<Role> getUserNotRoles(User user)
	{
		return roleRepository.getUserNotRoles(user.getId());
	}
}
