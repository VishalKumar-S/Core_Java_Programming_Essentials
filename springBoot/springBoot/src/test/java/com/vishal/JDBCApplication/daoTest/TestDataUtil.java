package com.vishal.DBApplication.daoTest;

import com.vishal.DBApplication.Author;
import com.vishal.DBApplication.Book;

public class TestDataUtil {
    static Book getBook1() {
        return Book.builder().isbn("846-43484-243").title("The aware").author_id(12).build();
    }
    static Book getBook2() {
        return Book.builder().isbn("746-43484-243").title("he aware").author_id(13).build();
    }
    static Book getBook3() {
        return Book.builder().isbn("646-43484-243").title("e aware").author_id(14).build();
    }

    static Author getAuthor1() {
        return Author.builder().author_id(12).name("vishal").age(1).build();
    }

    static Author getAuthor2() {
        return Author.builder().author_id(13).name("kumar").age(2).build();
    }

    static Author getAuthor3() {
        return Author.builder().author_id(14).name(". S").age(3).build();
    }
}
