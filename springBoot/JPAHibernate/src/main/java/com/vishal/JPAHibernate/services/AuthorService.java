package com.vishal.JPAHibernate.services;

import com.vishal.JPAHibernate.Entities.Author;

import java.util.List;

public interface AuthorService {
    public Author saveAuthor(Author author);
    List<Author> findAll();
}
