package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.Country;
import com.ck.apmApp.repositories.CountryRepository;

@Service
public class CountryService {
	@Autowired
	private CountryRepository countryRepository;

	// Returns a list of countries
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	// Save new country
	public void save(Country country) {
		countryRepository.save(country);
	}

	// get by id
	public Optional<Country> findById(Integer id) {
		return countryRepository.findById(id);
	}

	public void delete(Integer id) {
		countryRepository.deleteById(id);
	}
}
