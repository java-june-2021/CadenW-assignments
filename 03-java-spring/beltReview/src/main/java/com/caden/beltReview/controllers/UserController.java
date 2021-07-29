package com.caden.beltReview.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caden.beltReview.models.User;
import com.caden.beltReview.services.UserService;
import com.caden.beltReview.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@Autowired UserValidator uValidator;

	@GetMapping("/")
	public String login(@ModelAttribute("user") User user) {
		return "log.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		uValidator.validate(user, result);
		if(result.hasErrors()) {
			return "log.jsp";
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
}

