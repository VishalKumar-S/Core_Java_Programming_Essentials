package com.vishal.DBApplication.dao;
import com.vishal.DBApplication.Author;

import java.util.List;
import java.util.Optional;

public interface authorDao {
    void create(Author author);
    Optional<Author> readOne(Integer authorID);
    public List<Author> readAll();
}


