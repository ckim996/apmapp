package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.Employee;
import com.ck.apmApp.models.User;
import com.ck.apmApp.repositories.EmployeeRepository;
import com.ck.apmApp.repositories.UserRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;

	// Returns a list of employees
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	// Save new employee
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	// get by id
	public Optional<Employee> findById(Integer id) {
		return employeeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}

	public Employee findByUserName(String un) {
		return employeeRepository.findByUsername(un);
	}
	
	public void assignUsername(int id)
	{
		Employee employee = employeeRepository.findById(id).orElse(null);
		User user = userRepository.findByFirstnameAndLastname(
				employee.getFirstname(),
				employee.getLastname()
				);
		employee.setUsername(user.getUsername());
		employeeRepository.save(employee);
	}
}
