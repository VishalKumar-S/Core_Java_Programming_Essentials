package com.vishal.JPAHibernate;

import com.vishal.JPAHibernate.DTO.AuthorDTO;
import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.Entities.Book;

public class TestDataUtil {
    public static Book getBook1(final Author author) {
        return Book.builder().isbn("846-43484-243").title("The aware").author(author).build();
    }



    public static Book getBook2(final Author author) {
        return Book.builder().isbn("746-43484-243").title("he aware").author(author).build();
    }
    public static Book getBook3(final Author author) {
        return Book.builder().isbn("646-43484-243").title("e aware").author(author).build();
    }

    public static Author getAuthor1() {
        return Author.builder().name("vishal").age(1).build();
    }

    public static AuthorDTO getAuthorDTO1() {
        return AuthorDTO.builder().name("vishal").age(1).build();
    }


    public static Author getAuthor2() {
        return Author.builder().name("kumar").age(2).build();
    }

    public static Author getAuthor3() {
        return Author.builder().name(". S").age(3).build();
    }
}
