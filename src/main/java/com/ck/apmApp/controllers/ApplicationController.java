package com.ck.apmApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController 
{
	@GetMapping("/index")
	public String goHome()
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied()
	{
		return "accessDenied";
	}
	
	@GetMapping("/logout")
	public String logout()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
}
