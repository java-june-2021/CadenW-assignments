package com.caden.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caden.books.models.Book;
import com.caden.books.services.BookService;

@RestController 
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private BookService bService;
	
	@GetMapping("")
	public List<Book> allBooks(){
		return this.bService.allBooks();
	}
	@GetMapping("/{id}")
	public Book getOneBook(@PathVariable("id") Long id) {
		return this.bService.getById(id);
	}
	@PostMapping("/create")
	public Book createBook(Book book) {
		return this.bService.createBook(book);
	}
	@PutMapping("/{id}")
	public void updateBook(@PathVariable("id") Long id, Book book) {
		this.bService.updateBook(book);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		this.bService.deleteBook(id);
	}

}
