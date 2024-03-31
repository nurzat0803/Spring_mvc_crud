package com.JavaXSTACK.dao;

import com.JavaXSTACK.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public BookDaoImpl(SessionFactory sessionFactory) { /**/
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book bookSave) {
        getCurrentSession().save(bookSave);
    }

    @Override
    public Book getBookById(int id) {
        Book bookGet = (Book) getCurrentSession().get(Book.class,id);
        return bookGet;
    }

    @Override
    public void updateBook(Book book) {
        Book bookToEdit = getBookById(book.getId());
        bookToEdit.setBookAuthor(book.getBookAuthor());
        bookToEdit.setPrice(book.getPrice());
        getCurrentSession().update(bookToEdit);
    }

    @Override
    public List listBooks() {
        return getCurrentSession().createQuery("from Book").list();
    }

    @Override
    public void deleteBookById(int id) {
        Book bookRemove = getBookById (id);
        if (bookRemove != null) {
            getCurrentSession().delete(bookRemove);
        }
    }
}
