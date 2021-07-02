package com.caden.dojoSurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoController {
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(path="/surveyResults", method=RequestMethod.POST)
	public String surveyResults(@RequestParam("name") String name, @RequestParam("location") String location, @RequestParam("lang") String lang, @RequestParam("desc") String desc, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("location", location);
		viewModel.addAttribute("lang", lang);
		viewModel.addAttribute("desc", desc);
		if(lang.equals("Java")) {
			return "java.jsp";
		}
		return "results.jsp";
	}
	
	

}
