package com.vishal.JPAHibernate.services.implementation;

import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.Entities.Book;
import com.vishal.JPAHibernate.repositories.BookRepository;
import com.vishal.JPAHibernate.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private BookRepository bookRepository;

    public BookServiceImplementation(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }




}
