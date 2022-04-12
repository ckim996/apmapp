package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.VehicleMaintenance;
import com.ck.apmApp.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService 
{
	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;

	// Returns a list of vehicleMaintenances
	public List<VehicleMaintenance> findAll() {
		return vehicleMaintenanceRepository.findAll();
	}

	// Save new vehicleMaintenance
	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}

	// get by id
	public Optional<VehicleMaintenance> findById(Integer id) {
		return vehicleMaintenanceRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleMaintenanceRepository.deleteById(id);
	}
}
