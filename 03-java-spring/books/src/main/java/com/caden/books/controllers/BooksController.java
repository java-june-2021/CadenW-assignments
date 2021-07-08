package com.caden.books.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caden.books.models.Book;
import com.caden.books.services.BookService;

@Controller
public class BooksController {
    private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@ModelAttribute("book") Book book) {
            bookService.createBook(book);
            return "redirect:/books";
    }
    @RequestMapping(path="/books/{id}", method=RequestMethod.GET)
    public String findBookById(Model model, @PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "showBook.jsp";
    }
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "new.jsp";
    }
    @RequestMapping("/books/{id}/edit")
    public String editBook(Model model, @PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        bookService.editBook(book);
        return "editBook.jsp";
    }
    @RequestMapping("/books/{id}/update")
    public String updateBook(Book book) {
        bookService.editBook(book);
        return "editBook.jsp";
    }
    
}
