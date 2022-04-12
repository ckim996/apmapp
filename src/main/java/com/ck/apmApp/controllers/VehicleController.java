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

import com.ck.apmApp.models.Vehicle;
import com.ck.apmApp.models.VehicleMake;
import com.ck.apmApp.models.VehicleModel;
import com.ck.apmApp.models.VehicleStatus;
import com.ck.apmApp.models.VehicleType;
import com.ck.apmApp.models.Employee;
import com.ck.apmApp.models.Location;
import com.ck.apmApp.services.VehicleService;
import com.ck.apmApp.services.VehicleStatusService;
import com.ck.apmApp.services.VehicleTypeService;
import com.ck.apmApp.services.EmployeeService;
import com.ck.apmApp.services.LocationService;
import com.ck.apmApp.services.VehicleMakeService;
import com.ck.apmApp.services.VehicleModelService;

@Controller
public class VehicleController {
	
	// Location, employee, VehicleMake, VehicleStatus, VehicleModel, VehicleType, Vehicles
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private VehicleMakeService vehicleMakeService;
	@Autowired
	private VehicleStatusService vehicleStatusService;
	@Autowired
	private VehicleTypeService vehicleTypeService;
	@Autowired
	private VehicleModelService vehicleModelService;

	@GetMapping("/vehicles")
	public String findAll(Model model) {
		List<Vehicle> vehicleList = vehicleService.findAll();
		model.addAttribute("vehicles", vehicleList);

		List<Location> locationList = locationService.findAll();
		model.addAttribute("locations", locationList);

		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employees", employeeList);
		
		List<VehicleMake> vehicleMakeList = vehicleMakeService.findAll();
		model.addAttribute("vehicleMakes", vehicleMakeList);

		List<VehicleStatus> vehicleStatusList = vehicleStatusService.findAll();
		model.addAttribute("vehicleStatuses", vehicleStatusList);
		
		List<VehicleType> vehicleTypeList = vehicleTypeService.findAll();
		model.addAttribute("vehicleTypes", vehicleTypeList);

		List<VehicleModel> vehicleModelList = vehicleModelService.findAll();
		model.addAttribute("vehicleModels", vehicleModelList);

		return "Vehicle";
	}

	@PostMapping("/vehicles/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}

	@RequestMapping("/vehicles/findById")
	@ResponseBody
	public Optional<Vehicle> findById(Integer id) {
		return vehicleService.findById(id);
	}

	@RequestMapping(value = "/vehicles/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}

	@RequestMapping(value = "/vehicles/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleService.delete(id);
		return "redirect:/vehicles";
	}
}
