package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.Supplier;
import com.ck.apmApp.repositories.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;

	// Returns a list of suppliers
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	// Save new supplier
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	// get by id
	public Optional<Supplier> findById(Integer id) {
		return supplierRepository.findById(id);
	}

	public void delete(Integer id) {
		supplierRepository.deleteById(id);
	}
}
