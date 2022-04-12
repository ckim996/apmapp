package com.ck.apmApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ck.apmApp.models.Country;
import com.ck.apmApp.models.Location;
import com.ck.apmApp.models.State;
import com.ck.apmApp.services.CountryService;
import com.ck.apmApp.services.LocationService;
import com.ck.apmApp.services.StateService;

@Controller
public class LocationController 
{
	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;
	@Autowired private LocationService locationService;
	
	@GetMapping("/locations")
	public String findAll(Model model)
	{
		List<State> stateList = stateService.findAll();
		model.addAttribute("states", stateList);
		
		List<Country> countryList = countryService.findAll();
		model.addAttribute("countries", countryList);
		
		List<Location> locationList = locationService.findAll();
		model.addAttribute("locations", locationList);
		
		return "Location";
	}
	
	@PostMapping("/locations/addNew")
	public String addNew(Location location)
	{
		locationService.save(location);
		return "redirect:/locations";
	}
	
	@RequestMapping("/locations/findById") 
	@ResponseBody
	public Optional<Location> findById(Integer id)
	{
		return locationService.findById(id);
	}
	
	@RequestMapping(value = "/locations/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Location location)
	{
		locationService.save(location);
		return "redirect:/locations";
	}
	
	@RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		locationService.delete(id);
		return "redirect:/locations";
	}
}
