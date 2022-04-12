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

import com.ck.apmApp.models.Client;
import com.ck.apmApp.models.Location;
import com.ck.apmApp.models.Vehicle;
import com.ck.apmApp.models.VehicleHire;
import com.ck.apmApp.services.ClientService;
import com.ck.apmApp.services.LocationService;
import com.ck.apmApp.services.VehicleHireService;
import com.ck.apmApp.services.VehicleService;

@Controller
public class VehicleHireController {
	@Autowired
	private VehicleHireService vehicleHireService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/vehicleHires")
	public String findAll(Model model) {

		List<VehicleHire> vehicleHireList = vehicleHireService.findAll();
		model.addAttribute("vehicleHires", vehicleHireList);
		List<Vehicle> vehicleList = vehicleService.findAll();
		model.addAttribute("vehicles", vehicleList);
		List<Location> locationList = locationService.findAll();
		model.addAttribute("locations", locationList);
		List<Client> clientList = clientService.findAll();
		model.addAttribute("clients", clientList);

		return "VehicleHire";
	}

	@PostMapping("/vehicleHires/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}

	@RequestMapping("/vehicleHires/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(Integer id) {
		return vehicleHireService.findById(id);
	}

	@RequestMapping(value = "/vehicleHires/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}

	@RequestMapping(value = "/vehicleHires/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/vehicleHires";
	}
}
