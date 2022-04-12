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

import com.ck.apmApp.models.VehicleStatus;
import com.ck.apmApp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	@Autowired
	private VehicleStatusService vehicleStatusService;

	@GetMapping("/vehicleStatuses")
	public String findAll(Model model) {

		List<VehicleStatus> vehicleStatusList = vehicleStatusService.findAll();
		model.addAttribute("vehicleStatuses", vehicleStatusList);

		return "VehicleStatus";
	}

	@PostMapping("/vehicleStatuses/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}

	@RequestMapping("/vehicleStatuses/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(Integer id) {
		return vehicleStatusService.findById(id);
	}

	@RequestMapping(value = "/vehicleStatuses/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}

	@RequestMapping(value = "/vehicleStatuses/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatuses";
	}
}
