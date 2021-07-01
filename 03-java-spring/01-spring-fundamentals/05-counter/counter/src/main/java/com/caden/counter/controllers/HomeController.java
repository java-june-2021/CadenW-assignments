
package com.caden.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			int counter = (int) session.getAttribute("count");
			counter++;
			session.setAttribute("count", counter);
			
		}
		return "index.jsp";
	}
	@RequestMapping(path="/doubleCounter", method=RequestMethod.GET)
	public String doubleCounter(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			int counter = (int) session.getAttribute("count");
			counter+=2;
			session.setAttribute("count", counter);
		}
		return "double.jsp";
	}
	@RequestMapping(path="/counter", method=RequestMethod.GET)
	public String counter(Model viewModel, HttpSession session) {
		Integer currentCount = (Integer)session.getAttribute("count");
		if(currentCount == null) {
			viewModel.addAttribute("current", 0);
		} else {
			viewModel.addAttribute("current", currentCount);
		}
		return "counter.jsp";
	}
	@RequestMapping(path="/reset", method=RequestMethod.GET)
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "index.jsp";
	}
	
	

}
