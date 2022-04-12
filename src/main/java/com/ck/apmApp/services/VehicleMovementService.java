package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.VehicleMovement;
import com.ck.apmApp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;

	// Returns a list of vehicleMovements
	public List<VehicleMovement> findAll() {
		return vehicleMovementRepository.findAll();
	}

	// Save new vehicleMovement
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}

	// get by id
	public Optional<VehicleMovement> findById(Integer id) {
		return vehicleMovementRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleMovementRepository.deleteById(id);
	}
}
