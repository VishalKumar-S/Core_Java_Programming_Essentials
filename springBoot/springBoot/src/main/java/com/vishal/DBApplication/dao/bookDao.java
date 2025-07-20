package com.vishal.DBApplication.dao;
import com.vishal.DBApplication.Author;
import com.vishal.DBApplication.Book;

import java.util.Optional;

public interface bookDao{
    void create(Book book);
    Optional<Book> readOne(String isbn);
}