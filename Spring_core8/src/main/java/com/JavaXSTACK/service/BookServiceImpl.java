package com.JavaXSTACK.service;

import com.JavaXSTACK.dao.BookDao;
import com.JavaXSTACK.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Qualifier("bookDao")
    @Autowired
    private BookDao bookDao;

    @Override
    public void addBook(Book bookAdd) {
        bookDao.addBook(bookAdd);
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public void updateBook(Book bookUpdate) {
        bookDao.updateBook(bookUpdate);
    }

    @Override
    public List listBooks() {
        return bookDao.listBooks();
    }

    @Override
    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);
    }
}
