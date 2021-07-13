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
import org.springframework.web.bind.annotation.PutMapping;

import com.caden.languages.models.Language;
import com.caden.languages.services.LanguageService;

@Controller
//@RequestMapping("/languages")
public class HomeController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("language") Language language, Model viewModel) {
		viewModel.addAttribute("allLanguages", this.lService.allLanguages());
		return "index.jsp";
	}
	@PostMapping("/languages")
	public String addlang(@Valid @ModelAttribute("language") Language language,  BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("allLanguages", this.lService.allLanguages());
			return "index.jsp";
		}
		this.lService.addLang(language);
		return "redirect:/languages";
	}
	@GetMapping("/languages/{id}")
	public String showLanguage(Model viewModel, @PathVariable("id") Long id) {
		Language thisLang = this.lService.getOneLang(id);
		viewModel.addAttribute("lang", thisLang);
		return "show.jsp";
	}
	@GetMapping("/languages/{id}/edit")
	public String edit(@ModelAttribute("language") Language language, Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("language", this.lService.getOneLang(id));
		return "edit.jsp";
	}
	@PostMapping("/languages/{id}/edit")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "/edit.jsp";
		}
		this.lService.update(language);
		return "redirect:/languages";
	}
	@GetMapping("/languages/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		this.lService.delete(id);
		return "redirect:/languages";
	}
	
}
