package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.Invoice;
import com.ck.apmApp.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;

	// Returns a list of invoices
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

	// Save new invoice
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	// get by id
	public Optional<Invoice> findById(Integer id) {
		return invoiceRepository.findById(id);
	}

	public void delete(Integer id) {
		invoiceRepository.deleteById(id);
	}
}
