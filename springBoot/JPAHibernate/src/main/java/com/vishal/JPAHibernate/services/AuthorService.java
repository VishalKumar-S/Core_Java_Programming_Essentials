package com.vishal.JPAHibernate.services;

import com.vishal.JPAHibernate.Entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public Author saveAuthor(Author author);
    List<Author> findAll();
    Optional<Author> findOne(Integer id);
    Boolean isExists(Integer id);
    Author partialUpdateAuthor(Author author);
    void deleteAuthor(Integer id);

}
