package com.caden.theCode.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(path="/guess", method=RequestMethod.POST)
	public String guess(Model viewModel, @RequestParam("guess") String code, RedirectAttributes redirectAttr){
		if(code.equals("bushido")) {
			ArrayList<String> codeDisplay = new ArrayList<String>();
			codeDisplay.add("Loyalty");
			codeDisplay.add("Courage");
			codeDisplay.add("Veracity");
			codeDisplay.add("Comapssion");
			codeDisplay.add("Honor");
			viewModel.addAttribute("codeDisplay", codeDisplay);
			return "code.jsp";
		} else {
			redirectAttr.addFlashAttribute("error", "You Must Try Harder");
			return "redirect:/";
		}
	}
}
