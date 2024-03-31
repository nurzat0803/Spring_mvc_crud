package com.JavaXSTACK.dao;

import com.JavaXSTACK.model.Book;

import java.util.List;

public interface BookDao {
    public void addBook(Book bookAdd);
    public Book getBookById(int id);
    public void updateBook(Book book);
    public List<Book> listBooks();
    public void deleteBookById(int id);
}

