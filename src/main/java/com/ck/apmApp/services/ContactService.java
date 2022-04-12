package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.Contact;
import com.ck.apmApp.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;

	// Returns a list of contacts
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	// Save new contact
	public void save(Contact contact) {
		contactRepository.save(contact);
	}

	// get by id
	public Optional<Contact> findById(Integer id) {
		return contactRepository.findById(id);
	}

	public void delete(Integer id) {
		contactRepository.deleteById(id);
	}
}
