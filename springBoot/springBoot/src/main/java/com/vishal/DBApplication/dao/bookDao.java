package com.vishal.DBApplication.dao;
import com.vishal.DBApplication.author;
import com.vishal.DBApplication.book;

import java.util.Optional;

public interface bookDao{
    void create(book book);
    Optional<book> readOne(String isbn);
}