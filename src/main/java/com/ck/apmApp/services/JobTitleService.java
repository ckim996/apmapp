package com.ck.apmApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.apmApp.models.JobTitle;
import com.ck.apmApp.repositories.JobTitleRepository;

@Service
public class JobTitleService {
	@Autowired
	private JobTitleRepository jobTitleRepository;

	// Returns a list of jobTitles
	public List<JobTitle> findAll() {
		return jobTitleRepository.findAll();
	}

	// Save new jobTitle
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}

	// get by id
	public Optional<JobTitle> findById(Integer id) {
		return jobTitleRepository.findById(id);
	}

	public void delete(Integer id) {
		jobTitleRepository.deleteById(id);
	}
}
