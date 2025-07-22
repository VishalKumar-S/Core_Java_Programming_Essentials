package com.vishal.DBApplication.dao;
import com.vishal.DBApplication.Author;
import com.vishal.DBApplication.Book;

import java.util.List;
import java.util.Optional;

public interface bookDao{
    void create(Book book);
    Optional<Book> readOne(String isbn);
    public List<Book> readAll();
    void update(Book book, String isbn);

}