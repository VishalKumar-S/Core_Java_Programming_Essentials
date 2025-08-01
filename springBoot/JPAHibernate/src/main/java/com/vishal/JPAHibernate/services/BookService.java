package com.vishal.JPAHibernate.services;

import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.Entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BookService {
    public Book saveBook(Book book);
    List<Book> findAll();

}
