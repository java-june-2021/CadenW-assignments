package com.caden.dojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caden.dojosAndNinjas.models.Dojo;
import com.caden.dojosAndNinjas.models.Ninja;
import com.caden.dojosAndNinjas.services.DojoService;
import com.caden.dojosAndNinjas.services.NinjaService;

@Controller 
public class DojoController {
	@Autowired
	private DojoService dService;
	
	@Autowired
	private NinjaService nService;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo, Model viewModel) {
		viewModel.addAttribute("allDojos", this.dService.allDojos());
		return "index.jsp";
	}
	@PostMapping("/dojo/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("allDojos", this.dService.allDojos());
			return "index.jsp";
		}
		this.dService.createDojo(dojo);
		return "redirect:/";
	}
	@GetMapping("/ninja/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		viewModel.addAttribute("dojos", this.dService.allDojos());
		return "newNinja.jsp";
	}
	@PostMapping("/ninja/add")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		this.nService.create(ninja);
		return "redirect:/";
	}
	@GetMapping("/dojo/{id}")
	public String showDojo(Model viewModel, @PathVariable("id") Long id) {
		Dojo dojoToShow = this.dService.getOneDojo(id);
		viewModel.addAttribute("dojo", dojoToShow);
		return "show.jsp";
	}

}
