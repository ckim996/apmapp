package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.VehicleType;
import com.ck.apmApp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	// Returns a list of vehicleTypes
	public List<VehicleType> findAll() {
		return vehicleTypeRepository.findAll();
	}

	// Save new vehicleType
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}

	// get by id
	public Optional<VehicleType> findById(Integer id) {
		return vehicleTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleTypeRepository.deleteById(id);
	}
}
