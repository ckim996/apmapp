package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.State;
import com.ck.apmApp.repositories.StateRepository;

@Service
public class StateService 
{
	@Autowired
	private StateRepository stateRepository;

	// Returns a list of states
	public List<State> findAll() {
		return stateRepository.findAll();
	}

	// Save new state
	public void save(State state) {
		stateRepository.save(state);
	}

	// get by id
	public Optional<State> findById(Integer id) {
		return stateRepository.findById(id);
	}

	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}
}
