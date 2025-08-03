package com.vishal.JPAHibernate.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {
    @Id
    private String isbn;
    private String title;

//    CascadeType.PERSIST: When you save a new Book linked to a new Author, Hibernate will save the Author first, then the Book.•
//
//    CascadeType.MERGE: When you update an existing Book and link it to a new Author, this ensures the new Author is saved correctly.
//
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "author_id")
    private Author author;
}
