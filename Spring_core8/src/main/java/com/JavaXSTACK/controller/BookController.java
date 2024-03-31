package com.JavaXSTACK.controller;

import com.JavaXSTACK.model.Book;
import com.JavaXSTACK.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/")
    public ModelAndView listBooks() {
        ModelAndView modelAndView = new ModelAndView("bookList");
        List<Book> books = bookService.listBooks();
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/book/getBookAddPage")
    public ModelAndView addBookPage() {
        ModelAndView modelAndView = new ModelAndView("bookSave");
        modelAndView.addObject("bookAdd", new Book());
        return modelAndView;
    }

    @PostMapping("/books/getBookAddPage")
    public ModelAndView bookSave(@ModelAttribute Book book) {
        bookService.addBook(book);
        List<Book> bookList = bookService.listBooks();
        ModelAndView modelAndView = new ModelAndView("bookList");
        modelAndView.addObject("books", bookList);
        return modelAndView;
    }
/**/

    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "update_book";
    }

    @PostMapping("/books/{id}")
    public String editBook(@PathVariable(value = "id") Integer id,
                             @ModelAttribute Book bookDetail,
                             Model model) {
        model.addAttribute("books");
        Book exitBook = bookService.getBookById(id);

        exitBook.setId(id);
        exitBook.setBookAuthor(bookDetail.getBookAuthor());
        exitBook.setPrice(bookDetail.getPrice());
        bookService.updateBook(exitBook);
        return "redirect:/";
    }

    @GetMapping ("/book/{id}")
    public String deleteBook(@PathVariable(value = "id") Integer id, Model model) {
        Book book = bookService.getBookById(id);
        bookService.deleteBookById(id);
        return "redirect:/";
    }
}