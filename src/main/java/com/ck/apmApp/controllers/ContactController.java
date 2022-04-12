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

import com.ck.apmApp.models.Contact;
import com.ck.apmApp.models.Country;
import com.ck.apmApp.models.State;
import com.ck.apmApp.services.ContactService;
import com.ck.apmApp.services.CountryService;
import com.ck.apmApp.services.StateService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;

	@GetMapping("/contacts")
	public String findAll(Model model) {
		List<Contact> contactList = contactService.findAll();
		model.addAttribute("contacts", contactList);

		List<Country> countryList = countryService.findAll();
		model.addAttribute("countries", countryList);

		List<State> stateList = stateService.findAll();
		model.addAttribute("states", stateList);

		return "ContactCK";
	}

	@PostMapping("/contacts/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}

	@RequestMapping("/contacts/findById")
	@ResponseBody
	public Optional<Contact> findById(Integer id) {
		return contactService.findById(id);
	}

	@RequestMapping(value = "/contacts/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}

	@RequestMapping(value = "/contacts/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}
}
