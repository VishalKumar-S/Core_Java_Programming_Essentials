package com.vishal.JPAHibernate.services.implementation;

import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.Entities.Book;
import com.vishal.JPAHibernate.repositories.BookRepository;
import com.vishal.JPAHibernate.services.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Boolean isExists(String isbn) {
        return bookRepository.existsById(isbn);

    }

    @Override
    public Book partialUpdateBook(Book newBook) {
        return bookRepository.findById(newBook.getIsbn()).map(oldBook -> {
            Optional.ofNullable(newBook.getAuthor()).ifPresent(oldBook
            ::setAuthor);
            Optional.ofNullable(newBook.getTitle()).ifPresent(oldBook
                    ::setTitle);

            return saveBook(oldBook);

        }).orElseThrow(() -> new EntityNotFoundException("Book not found with ISBN " + newBook.getIsbn()));
    }

    @Override
    public void deleteBook(String isbn) {
        bookRepository.delete(bookRepository.findById(isbn).get());
    }


}
