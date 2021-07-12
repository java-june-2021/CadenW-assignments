package com.caden.books.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.caden.books.models.Book;
import com.caden.books.services.BookService;

@Controller
public class BookController {
	//Importing bookServices and all that comes with it which are my CRUD methods ive already created 
	@Autowired
	private BookService bService;
	
	//displaying all the books on the 1st page 
	@GetMapping("/")
	public String homePage(Model viewModel) {
		viewModel.addAttribute("allBooks", this.bService.allBooks());
		return "index.jsp";
	}
	
	//creating a new book taking in an empty object and loading the jsp page 
	
	@GetMapping("/new/book")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	//finally taking that information and creating the book as long as it meets all the requirements 
	@PostMapping("/addBook")
	public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		this.bService.createBook(book);
		return "redirect:/";
	}
	//view one individual book 
	@GetMapping("/book/{id}")
	public String showBook(Model viewModel, @PathVariable("id") Long id) {
		Book bookToShow = this.bService.getById(id);
		viewModel.addAttribute("book", bookToShow);
		return "showBook.jsp";
	}
	//editing a book 
	@GetMapping("/{id}/edit")
	public String edit(@ModelAttribute("book") Book book, Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("book", this.bService.getById(id));
		return "edit.jsp";
	}
	@PostMapping("/{id}/edit")
	public String update(@Valid @ModelAttribute("book") Book book, Model viewModel, @PathVariable("id") Long id, BindingResult result) {
		if(result.hasErrors()) {
			viewModel.addAttribute("book", this.bService.getById(id));
			return "/edit.jsp";
		}
		this.bService.updateBook(book);
		return "redirect:/";
	}
	@GetMapping("{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		this.bService.deleteBook(id);
		return "redirect:/";
	}
	

}
