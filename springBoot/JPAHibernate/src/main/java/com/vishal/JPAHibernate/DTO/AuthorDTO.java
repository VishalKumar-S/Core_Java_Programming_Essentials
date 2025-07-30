package com.vishal.JPAHibernate.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vishal.JPAHibernate.Entities.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDTO {
    private Integer author_id;

    private String name;

    @JsonProperty("vayasu")
    private Integer age;

    private List<BookDTO> books = new ArrayList<>();

    public void addBook(BookDTO book){
        this.books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(BookDTO book){
        this.books.remove(book);
        book.setAuthor(null);
    }
}
