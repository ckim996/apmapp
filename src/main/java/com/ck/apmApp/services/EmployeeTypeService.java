package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.EmployeeType;
import com.ck.apmApp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;

	// Returns a list of employeeTypes
	public List<EmployeeType> findAll() {
		return employeeTypeRepository.findAll();
	}

	// Save new employeeType
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}

	// get by id
	public Optional<EmployeeType> findById(Integer id) {
		return employeeTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);
	}
}
