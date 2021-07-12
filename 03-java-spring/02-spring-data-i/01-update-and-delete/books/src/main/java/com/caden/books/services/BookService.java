package com.caden.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caden.books.models.Book;
import com.caden.books.repositories.BookRepository;

@Service 
public class BookService {
	private BookRepository bRepo;
	public BookService(BookRepository bRepo) {
		this.bRepo = bRepo;
	}
	//display all books in db 
	public List<Book> allBooks(){
		return this.bRepo.findAll();
	}
	
	//Create a book
	public Book createBook(Book book) {
		return this.bRepo.save(book);
	}
	//view or read a single book details 
	public Book getById(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	//update a already existing book
	public Book updateBook(Book book) {
		return this.bRepo.save(book);
	}
	// delete a book 
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}

}
