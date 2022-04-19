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
import com.ck.apmApp.models.Employee;
import com.ck.apmApp.models.EmployeeType;
import com.ck.apmApp.models.JobTitle;
import com.ck.apmApp.models.State;
import com.ck.apmApp.services.CountryService;
import com.ck.apmApp.services.EmployeeService;
import com.ck.apmApp.services.EmployeeTypeService;
import com.ck.apmApp.services.JobTitleService;
import com.ck.apmApp.services.StateService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JobTitleService jobTitleService;
	@Autowired
	private EmployeeTypeService employeeTypeService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;

	@GetMapping("/employees")
	public String findAll(Model model) {
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employees", employeeList);

		List<JobTitle> jobTitleList = jobTitleService.findAll();
		model.addAttribute("jobTitles", jobTitleList);

		List<EmployeeType> employeeTypeList = employeeTypeService.findAll();
		model.addAttribute("employeeTypes", employeeTypeList);

		List<Country> countryList = countryService.findAll();
		model.addAttribute("countries", countryList);

		List<State> stateList = stateService.findAll();
		model.addAttribute("states", stateList);

		return "Employee";
	}

	@PostMapping("/employees/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}

	@RequestMapping("/employees/findById")
	@ResponseBody
	public Optional<Employee> findById(Integer id) {
		return employeeService.findById(id);
	}

	@RequestMapping(value = "/employees/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}

	@RequestMapping(value = "/employees/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}
	
	@RequestMapping(value = "/employees/assignUsername")
	public String assignUsername(int id)
	{
		employeeService.assignUsername(id);
		return "redirect:/employees";
	}
}
