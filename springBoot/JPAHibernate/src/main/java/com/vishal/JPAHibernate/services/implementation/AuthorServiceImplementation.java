package com.vishal.JPAHibernate.services.implementation;

import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.Entities.Book;
import com.vishal.JPAHibernate.repositories.AuthorRepository;
import com.vishal.JPAHibernate.repositories.BookRepository;
import com.vishal.JPAHibernate.services.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImplementation implements AuthorService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findOne(Integer id) {
        return authorRepository.findById(id);
    }


    @Override
    public Boolean isExists(Integer id) {
        return authorRepository.existsById(id);
    }

    @Override
    public Author partialUpdateAuthor(Author newAuthor) {
        return authorRepository.findById(newAuthor.getAuthor_id()).map(oldAuthor -> {
            Optional.ofNullable(newAuthor.getAuthorName()).ifPresent(oldAuthor::setAuthorName);
            Optional.ofNullable(newAuthor.getAge()).ifPresent(oldAuthor::setAge);

            if (newAuthor.getBooks() != null) {
                List<Book> persistentBook = newAuthor.getBooks().stream().map(book -> bookRepository.findById(book.getIsbn()).orElseThrow(() -> new EntityNotFoundException("Book not found with ISBN " + book.getIsbn()))).collect(Collectors.toList());

                oldAuthor.getBooks().clear();

                for(Book bookObjects: persistentBook){
                    oldAuthor.addBook(bookObjects);
                }
            }

            return authorRepository.save(oldAuthor);

        }).orElseThrow(() -> new EntityNotFoundException("Author not found with ID " + newAuthor.getAuthor_id()));
    }
}
