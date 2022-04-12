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

import com.ck.apmApp.models.VehicleMaintenance;
import com.ck.apmApp.models.Supplier;
import com.ck.apmApp.models.Vehicle;
import com.ck.apmApp.services.VehicleMaintenanceService;
import com.ck.apmApp.services.VehicleService;

import com.ck.apmApp.services.SupplierService;

@Controller
public class VehicleMaintenanceController {
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private SupplierService supplierService;

	@GetMapping("/vehicleMaintenances")
	public String findAll(Model model) {
		List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.findAll();
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceList);

		List<Vehicle> vehicleList = vehicleService.findAll();
		model.addAttribute("vehicles", vehicleList);
		
		List<Supplier> supplierList = supplierService.findAll();
		model.addAttribute("suppliers", supplierList);

		return "VehicleMaintenance";
	}

	@PostMapping("/vehicleMaintenances/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}

	@RequestMapping("/vehicleMaintenances/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(Integer id) {
		return vehicleMaintenanceService.findById(id);
	}

	@RequestMapping(value = "/vehicleMaintenances/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}

	@RequestMapping(value = "/vehicleMaintenances/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenances";
	}
}
