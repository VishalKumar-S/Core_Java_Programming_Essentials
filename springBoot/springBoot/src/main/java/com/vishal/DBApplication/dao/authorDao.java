package com.vishal.DBApplication.dao;
import com.vishal.DBApplication.author;
import java.util.Optional;

public interface authorDao {
    void create(author author);
    Optional<author> readOne(Integer authorID);
}


