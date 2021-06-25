package com.caden.strings.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HomeController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "Hello How are you?";
	}
	
	@RequestMapping(value="/random", method=RequestMethod.GET)
	public String hello() {
		return "Hello Beautiful!:)";
		
	}

}
