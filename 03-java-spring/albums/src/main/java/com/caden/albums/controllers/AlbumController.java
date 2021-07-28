package com.caden.albums.controllers;

import java.util.ArrayList;

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

import com.caden.albums.models.Album;
import com.caden.albums.models.Label;
import com.caden.albums.models.User;
import com.caden.albums.services.AlbumService;
import com.caden.albums.services.LabelService;
import com.caden.albums.services.UserService;
import com.caden.albums.validators.UserValidator;

@Controller
public class AlbumController {
	@Autowired
	private AlbumService aService;
	
	@Autowired
	private LabelService lService;
	
	@Autowired
	private UserService uService;
	
	@Autowired 
	private UserValidator uValidator;
	
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
		return "redirect:/albums";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttr, HttpSession session) {
		if(!this.uService.loginUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Email Or Password");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user__id", user.getId());
		return "redirect:/albums";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/albums")
	public String index(Model viewModel, HttpSession session) {
		if((Long)session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		Long thisUser = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("user", this.uService.findOneUser(thisUser));
		viewModel.addAttribute("allAlbums", this.aService.allAlbums());
		return "index.jsp";
	}
	@GetMapping("/new")
	public String newAlbum(@ModelAttribute("album") Album album, HttpSession session, Model viewModel) {
		Long userLoggedInId = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("userID", userLoggedInId);
		return "new.jsp";
	}
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		Long albumId = id;
		User liker = this.uService.findOneUser(userId);
		Album likedAlbum = this.aService.getOneAlbum(albumId);
		this.aService.addLike(likedAlbum, liker);
		return "redirect:/albums";
	}
	@GetMapping("/unLike/{id}")
	public String unLike(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		Long albumId = id;
		User liker = this.uService.findOneUser(userId);
		Album likedAlbum = this.aService.getOneAlbum(albumId);
		this.aService.removeLike(likedAlbum, liker);
		return "redirect:/albums";
	}
	@PostMapping("/addRecord")
	public String addAlbumJSTL(@Valid @ModelAttribute("album") Album album, BindingResult result) {
		if(result.hasErrors()){
			return "new.jsp";
		}
		this.aService.createAlbum(album);
		return "redirect:/albums";
	}
	@PostMapping("/addRecordHTMLWay")
	public String addAlbum(@RequestParam("bandName") String bandName, @RequestParam("albumName") String albumName, @RequestParam("releaseYear") int releaseYear, RedirectAttributes redirectAttr) {
		ArrayList<String> errors =new ArrayList<String>();
		if(bandName.equals("")) {
			errors.add("You cant leave this blank");
		}
		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("error", e);
			}
			return "redirect:/new";
		}
		Album newAlbum = new Album(bandName, albumName, releaseYear);
		this.aService.createAlbum(newAlbum);
		return "redirect:/";
	}
	@GetMapping("/album/{id}")
	public String show(Model viewModel, @PathVariable("id") Long id, @ModelAttribute("label") Label label, HttpSession session) {
		Album albumToShow = this.aService.getOneAlbum(id);
		viewModel.addAttribute("userThatsLoggedIn", session.getAttribute("user__id"));
		viewModel.addAttribute("album", albumToShow);
		return "show.jsp";
	}
	@PostMapping("/{albumId}/addLabel")
	public String addLabel(@Valid @ModelAttribute("label") Label label, BindingResult result, Model viewModel, @PathVariable("albumId") Long id) {
		if(result.hasErrors()) {
			Album albumToShow = this.aService.getOneAlbum(id);
			viewModel.addAttribute("album", albumToShow);
			return "show.jsp";
		}
		Album albumForLabel = this.aService.getOneAlbum(id);
		label.setAlbum(albumForLabel);
		this.lService.createLabel(label);
		return "redirect:/album/{albumId}";
	}
	@GetMapping("/{id}/edit")
	public String edit(@ModelAttribute("album") Album album, Model viewModel, @PathVariable("id") Long id, HttpSession session) {
		User userLoggedIn = this.uService.findOneUser((Long)session.getAttribute("user__id"));
		Album albumToShow = this.aService.getOneAlbum(id);
		if(albumToShow.getUser() != userLoggedIn) {
			return "redirect:/albums";
		}
		viewModel.addAttribute("userId", session.getAttribute("user__id"));
		viewModel.addAttribute("album", this.aService.getOneAlbum(id));
		return "/edit.jsp";
	}
	@PostMapping("/{id}/edit")
	public String update(@Valid @ModelAttribute("album") Album album, Model viewModel, @PathVariable("id") Long id, BindingResult result) {
		if(result.hasErrors()) {
			viewModel.addAttribute("album", this.aService.getOneAlbum(id));
			return "/edit.jsp";
		}
		this.aService.updateAlbum(album);
		return "redirect:/album/{id}";
	}
	@GetMapping("{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		this.aService.deleteAlbum(id);
		return "redirect:/";
	}
	@GetMapping("/profile/{id}")
	public String showUser(Model viewModel, @PathVariable("id") Long id) {
		User userToDisplayOnFrontEnd = this.uService.findOneUser(id);
		viewModel.addAttribute("userToDisplay", userToDisplayOnFrontEnd);
		return "profile.jsp";
	}
}
