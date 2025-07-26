package com.vishal.JPAHibernate.repositories;

import com.vishal.JPAHibernate.Author;
import com.vishal.JPAHibernate.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
