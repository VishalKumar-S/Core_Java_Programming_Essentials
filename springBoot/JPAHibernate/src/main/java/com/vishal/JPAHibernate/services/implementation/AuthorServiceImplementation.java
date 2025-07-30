package com.vishal.JPAHibernate.services.implementation;

import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.repositories.AuthorRepository;
import com.vishal.JPAHibernate.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImplementation implements AuthorService {

    private AuthorRepository authorRepository;
    public AuthorServiceImplementation(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
}
