package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.Client;
import com.ck.apmApp.repositories.ClientRepository;

@Service
public class ClientService 
{
	@Autowired
	private ClientRepository clientRepository;

	// Returns a list of clients
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	// Save new client
	public void save(Client client) {
		clientRepository.save(client);
	}

	// get by id
	public Optional<Client> findById(Integer id) {
		return clientRepository.findById(id);
	}

	public void delete(Integer id) {
		clientRepository.deleteById(id);
	}
}
