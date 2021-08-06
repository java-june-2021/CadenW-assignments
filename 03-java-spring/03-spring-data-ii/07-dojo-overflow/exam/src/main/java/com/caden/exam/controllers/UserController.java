package com.caden.exam.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caden.exam.models.Idea;
import com.caden.exam.models.User;
import com.caden.exam.services.IdeaService;
import com.caden.exam.services.UserService;
import com.caden.exam.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@Autowired
	private IdeaService iService;
	
	@Autowired 
	private UserValidator uValidator;
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		uValidator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uService.regUser(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttr, HttpSession session) {
		if(!this.uService.loginUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Email Or Password");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user__id", user.getId());
		return "redirect:/dashboard";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/dashboard")
	public String loggedIn(Model viewModel, HttpSession session) {
		if((Long)session.getAttribute("user__id") == null){
			return "redirect:/";
		}
		Long thisUser = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("thisUser", this.uService.findOneUser(thisUser));
		viewModel.addAttribute("allIdeas", this.iService.allIdeas());
		return "success.jsp";
	}
	@GetMapping("/newIdea")
	public String newIdea(@ModelAttribute("idea") Idea idea, Model viewModel, HttpSession session) {
		if((Long)session.getAttribute("user__id") == null){
			return "redirect:/";
		}
		Long thisUser = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("thisUser", this.uService.findOneUser(thisUser));
		return "newIdea.jsp";
	}
	@PostMapping("/createIdea")
	public String createIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model viewModel, HttpSession session) {
		if((Long)session.getAttribute("user__id") == null){
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "newIdea.jsp";
		}
		Long thisUser = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("thisUser", this.uService.findOneUser(thisUser));
		this.iService.createIdea(idea);
		return "redirect:/dashboard";
	}
	@GetMapping("/show/{id}")
	public String showIdea(Model viewModel, @PathVariable("id") Long id, HttpSession session) {
		if((Long)session.getAttribute("user__id") == null){
			return "redirect:/";
		}
		Long thisUser = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("thisUser", this.uService.findOneUser(thisUser));
		Idea ideaToShow = this.iService.getOneIdea(id);
		viewModel.addAttribute("idea", ideaToShow);
		return "show.jsp";
		
	}
	@GetMapping("/like/{id}")
	public String likeIdea(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		Long ideaId = id;
		User liker = this.uService.findOneUser(userId);
		Idea likedIdea = this.iService.getOneIdea(ideaId);
		this.iService.addLike(likedIdea, liker);
		return "redirect:/dashboard";
	}
	@GetMapping("/unlike/{id}")
	public String unlikeIdea(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		Long ideaId = id;
		User liker = this.uService.findOneUser(userId);
		Idea likedIdea = this.iService.getOneIdea(ideaId);
		this.iService.removeLike(likedIdea, liker);
		return "redirect:/dashboard";
	}
	@GetMapping("/edit/{id}")
	public String edit(@ModelAttribute("idea") Idea idea, Model viewModel, @PathVariable("id") Long id, HttpSession session) {
		if((Long)session.getAttribute("user__id") == null){
			return "redirect:/";
		}
		Long thisUser = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("thisUser", this.uService.findOneUser(thisUser));
		viewModel.addAttribute("idea", this.iService.getOneIdea(id));
		return "edit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model viewModel, @PathVariable("id") Long id, HttpSession session) {
		if((Long)session.getAttribute("user__id") == null){
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		Long thisUser = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("thisUser", this.uService.findOneUser(thisUser));
		this.iService.updateIdea(idea);
		return "redirect:/dashboard";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.iService.deleteIdea(id);
		return "redirect:/dashboard";
	}
	

}
