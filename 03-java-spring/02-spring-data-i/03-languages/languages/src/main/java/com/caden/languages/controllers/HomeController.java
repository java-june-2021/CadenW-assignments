package com.caden.languages.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.caden.languages.models.Language;
import com.caden.languages.services.LanguageService;

@Controller
//@RequestMapping("/languages")
public class HomeController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("")
	public String index(Model viewModel, @ModelAttribute("language") Language language) {
		viewModel.addAttribute("allLanguages", this.lService.allLanguages());
		return "index.jsp";
	}
	@PostMapping("/addLanguage")
	public String addlang(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		this.lService.addLang(language);
		return "redirect:/";
	}
	@GetMapping("/language/{id}")
	public String showLanguage(Model viewModel, @PathVariable("id") Long id) {
		Language thisLang = this.lService.getOneLang(id);
		viewModel.addAttribute("lang", thisLang);
		return "show.jsp";
	}
	
	
}
