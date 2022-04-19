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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ck.apmApp.models.User;
import com.ck.apmApp.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String findAll(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("users", userList);

		return "User";
	}

	@PostMapping("/users/addUser")
	public String addNew(User user) {
		userService.save(user);
		return "redirect:/users";
	}

	@RequestMapping("/users/findById")
	@ResponseBody
	public User findById(Integer id) {
		return userService.findById(id);
	}

	@RequestMapping(value = "/users/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(User user) {
		userService.save(user);
		return "redirect:/users";
	}

	@RequestMapping(value = "/users/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		userService.delete(id);
		return "redirect:/users";
	}

	@PostMapping(value = "users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.save(user);
		RedirectView redirectView = new RedirectView("/login", true);
		redir.addFlashAttribute("message", "You successfully registered. You may login");
		return redirectView;
	}
}
