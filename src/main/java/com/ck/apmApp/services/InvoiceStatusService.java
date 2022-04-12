package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.InvoiceStatus;
import com.ck.apmApp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;

	// Returns a list of invoiceStatuss
	public List<InvoiceStatus> findAll() {
		return invoiceStatusRepository.findAll();
	}

	// Save new invoiceStatus
	public void save(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}

	// get by id
	public Optional<InvoiceStatus> findById(Integer id) {
		return invoiceStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		invoiceStatusRepository.deleteById(id);
	}
}
