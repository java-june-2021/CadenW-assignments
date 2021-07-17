package com.caden.license.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caden.license.models.License;
import com.caden.license.models.User;
import com.caden.license.services.DMVService;

@Controller
public class HomeController {
	@Autowired
	private DMVService dSerivce;
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("users", this.dSerivce.getAllUsers());
		return "index.jsp";
	}
	@RequestMapping("user/new")
	public String newUser(@ModelAttribute("user") User user) {
		return "new.jsp";
	}
	@RequestMapping(path="/new", method=RequestMethod.POST)
	public String processUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		this.dSerivce.createUser(user);
		return "redirect:/";
	}
	@RequestMapping("/license/new")
	public String createLicense(Model viewModel, @ModelAttribute("license") License license) {
		viewModel.addAttribute("user", this.dSerivce.getUsersWithoutLicense());
		return "newLicense.jsp";
	}
	@RequestMapping(path="/newLicense", method=RequestMethod.POST)
	public String processLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("user", this.dSerivce.getUsersWithoutLicense());
			return "newLicense.jsp";
		}
		this.dSerivce.createLicense(license);
		return "redirect:/";
	}
	@RequestMapping("/show/{id}")
	public String showOneUser(Model viewModel, @PathVariable("id") Long id) {
		User thisUser = this.dSerivce.getOneUser(id);
		viewModel.addAttribute("user", thisUser);
		return "show.jsp";
		
	}
	
	
	

}
