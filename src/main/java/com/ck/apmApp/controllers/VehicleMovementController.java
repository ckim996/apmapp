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

import com.ck.apmApp.models.Location;
import com.ck.apmApp.models.Vehicle;
import com.ck.apmApp.models.VehicleMovement;
import com.ck.apmApp.services.LocationService;
import com.ck.apmApp.services.VehicleMovementService;
import com.ck.apmApp.services.VehicleService;

@Controller
public class VehicleMovementController {
	@Autowired
	private VehicleMovementService vehicleMovementService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;

	@GetMapping("/vehicleMovements")
	public String findAll(Model model) {
		List<VehicleMovement> vehicleMovementList = vehicleMovementService.findAll();
		model.addAttribute("vehicleMovements", vehicleMovementList);

		List<Vehicle> vehicleList = vehicleService.findAll();
		model.addAttribute("vehicles", vehicleList);

		List<Location> locationList = locationService.findAll();
		model.addAttribute("locations", locationList);

		return "VehicleMovement";
	}

	@PostMapping("/vehicleMovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}

	@RequestMapping("/vehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(Integer id) {
		return vehicleMovementService.findById(id);
	}

	@RequestMapping(value = "/vehicleMovements/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}

	@RequestMapping(value = "/vehicleMovements/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovements";
	}
}
