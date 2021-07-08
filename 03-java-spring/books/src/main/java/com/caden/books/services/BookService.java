package com.caden.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caden.books.models.Book;
import com.caden.books.repositories.BookRepository;

@Service 
public class BookService {
    // adding the book repository as a dependency
   private BookRepository bookRepository;
   
   public List<Book> allBooks(){
	   return bookRepository.findAll();
   }
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
    	return this.bookRepository.findById(id).orElse(null);
    }
    public Book editBook(Book book) {
    	return this.bookRepository.save(book);
    }
}


