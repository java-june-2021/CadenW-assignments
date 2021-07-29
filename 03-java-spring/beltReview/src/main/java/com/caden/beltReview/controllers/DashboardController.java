package com.caden.beltReview.controllers;

import javax.servlet.http.HttpSession;
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

import com.caden.beltReview.models.Thought;
import com.caden.beltReview.models.User;
import com.caden.beltReview.services.ThoughtService;
import com.caden.beltReview.services.UserService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	@Autowired
	private ThoughtService tService;
	@Autowired
	private UserService uService;
	
	@GetMapping("")
	public String Dashbaord(Model viewModel, @ModelAttribute("thought") Thought thought, HttpSession session) {
		viewModel.addAttribute("user", this.uService.findOneUser((Long)session.getAttribute("user__id")));
		viewModel.addAttribute("allThoughts", this.tService.allThoughts());
		return "dashboard.jsp";	
	}
	@PostMapping("/newThought")
	private String addThought(@Valid @ModelAttribute("thought") Thought thought, BindingResult result, Model viewModel, HttpSession session) {
		if(result.hasErrors()) {
			viewModel.addAttribute("user", this.uService.findOneUser((Long)session.getAttribute("user__id")));
			viewModel.addAttribute("allThoughts", this.tService.allThoughts());
			return "dashboard.jsp";
		}
		this.tService.createThought(thought);
		return "redirect:/dashboard";
	}
	@GetMapping("/{id}")
	public String display(@PathVariable("id") Long id, Model viewModel, HttpSession session) {
		viewModel.addAttribute("thought", this.tService.getOneThought(id));
		viewModel.addAttribute("user", this.uService.findOneUser((Long)session.getAttribute("user__id")));
		return "details.jsp";
	}
	@GetMapping("/like/{id}")
	public String like(HttpSession session, @PathVariable("id") Long id ) {
		Thought thought = this.tService.getOneThought(id);
		User userWhoLikedIt = this.uService.findOneUser((Long)session.getAttribute("user__id"));
		this.tService.likeThought(userWhoLikedIt, thought);
		return "redirect:/dashboard";
	}
	@GetMapping("/unlike/{id}")
	public String unlike(HttpSession session, @PathVariable("id") Long id ) {
		Thought thought = this.tService.getOneThought(id);
		User userWhoLikedIt = this.uService.findOneUser((Long)session.getAttribute("user__id"));
		this.tService.unlikeThought(userWhoLikedIt, thought);
		return "redirect:/dashboard";
	}
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		this.tService.deleteThought(id);
		return "redirect:/";
	}
	
	

}