package com.caden.gettingfamiliarwithrouting.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{dojo}")
	public String showDojo(@PathVariable("dojo") String dojoName) {
		return dojoName + " Is Awesome";
	}
	@RequestMapping("/{dojo}/{city}")
	public String showDojoAndCity(@PathVariable("dojo") String dojoName, @PathVariable("city") String cityName) {
		return cityName + " " + dojoName + " Is Located In Southern California";
	}
	@RequestMapping("/{dojo}/san-jose")
	public String headQuarters(@PathVariable("dojo") String dojoName) {
		return dojoName + " In San Jose is the headquarters";
	}
	
	

}
