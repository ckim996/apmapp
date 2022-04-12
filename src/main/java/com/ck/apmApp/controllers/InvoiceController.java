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
import com.ck.apmApp.models.Invoice;
import com.ck.apmApp.models.InvoiceStatus;
import com.ck.apmApp.services.ClientService;
import com.ck.apmApp.services.InvoiceService;
import com.ck.apmApp.services.InvoiceStatusService;

@Controller
public class InvoiceController 
{
	@Autowired private InvoiceService invoiceService;
	@Autowired private ClientService clientService;
	@Autowired private InvoiceStatusService invoiceStatusService;
	
	
	@GetMapping("/invoices")
	public String findAll(Model model)
	{
		List<Invoice> invoiceList = invoiceService.findAll();
		model.addAttribute("invoices", invoiceList);
		
		List<Client> clientList = clientService.findAll();
		model.addAttribute("clients", clientList);
		
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.findAll();
		model.addAttribute("invoiceStatuses", invoiceStatusList);
		
		return "Invoice";
	}
	
	@PostMapping("/invoices/addNew")
	public String addNew(Invoice invoice)
	{
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping("/invoices/findById") 
	@ResponseBody
	public Optional<Invoice> findById(Integer id)
	{
		return invoiceService.findById(id);
	}
	
	@RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Invoice invoice)
	{
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value = "/invoices/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		invoiceService.delete(id);
		return "redirect:/invoices";
	}
}
