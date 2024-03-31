package com.JavaXSTACK.service;

import com.JavaXSTACK.model.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book b); /**/
    public Book getBookById(int id); /**/
    public void updateBook(Book b);/**/
    public List<Book> listBooks();
    public void deleteBookById(int id);
}
