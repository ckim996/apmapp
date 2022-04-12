package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.Vehicle;
import com.ck.apmApp.repositories.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	// Returns a list of vehicles
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	// Save new vehicle
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	// get by id
	public Optional<Vehicle> findById(Integer id) {
		return vehicleRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleRepository.deleteById(id);
	}
}
