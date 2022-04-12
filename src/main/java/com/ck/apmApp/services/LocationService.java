package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.Location;
import com.ck.apmApp.repositories.LocationRepository;

@Service
public class LocationService {
	@Autowired
	private LocationRepository locationRepository;

	// Returns a list of locations
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	// Save new location
	public void save(Location location) {
		locationRepository.save(location);
	}

	// get by id
	public Optional<Location> findById(Integer id) {
		return locationRepository.findById(id);
	}

	public void delete(Integer id) {
		locationRepository.deleteById(id);
	}
}
