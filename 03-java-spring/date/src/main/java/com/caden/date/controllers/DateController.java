package com.caden.date.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DateController {
	private Date getDate() {
		Date now = new Date();
			return now;
	}
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index() {
		return "Date.jsp";
	}
	@RequestMapping(path="/date", method=RequestMethod.GET)
	public String date(Model viewModel) {
		viewModel.addAttribute ("datetime", getDate());
		return "DisplayDate.jsp";
		
	}
	@RequestMapping(path="/time", method=RequestMethod.GET)
	public String time(Model viewModel) {
		viewModel.addAttribute("datetime", getDate());
		return "DisplayTime.jsp";
		
	}

}
