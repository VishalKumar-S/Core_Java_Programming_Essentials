package com.vishal.JPAHibernate.repositories;

import com.vishal.JPAHibernate.Author;
import com.vishal.JPAHibernate.Book;
import com.vishal.JPAHibernate.TestDataUtil;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTest {
    private final BookRepository underTestBook;
    private final AuthorRepository underTestAuthor;

    @Autowired
    public BookRepositoryIntegrationTest(BookRepository underTestBook, AuthorRepository underTestAuthor){
        this.underTestBook = underTestBook;
        this.underTestAuthor = underTestAuthor;
        System.out.println("The entire purpose of cascade = CascadeType.ALL on the Author's books list is to simplify your code. It means that persistence operations (like creating, updating, or deleting) on the parent (Author) will automatically cascade down to its children (Book objects in the list). If you create a new Author, add a new Book to its list, and then save the Author, JPA should automatically save the Book as well. You should not need to call the BookRepository separately, to save the book.");

    }

    @Test
    @Transactional
    public void testThatBookCanBeCreatedAndRecalled(){

        Author author1 = TestDataUtil.getAuthor1();
        Book book1 = TestDataUtil.getBook1(author1);

        author1.addBook(book1);

        underTestAuthor.save(author1);


        Optional<Book> result = underTestBook.findById(book1.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book1);
    }


    @Test
    @Transactional
    public void testBooksCanBeCreatedAndRecalled(){
        Author author1 = TestDataUtil.getAuthor1();
        Book book1 = TestDataUtil.getBook1(author1);
        author1.addBook(book1);
        underTestAuthor.save(author1);


        Author author2 = TestDataUtil.getAuthor2();
        Book book2 = TestDataUtil.getBook2(author2);
        author2.addBook(book2);
        underTestAuthor.save(author2);

        Author author3 = TestDataUtil.getAuthor3();
        Book book3 = TestDataUtil.getBook3(author3);
        author3.addBook(book3);
        underTestAuthor.save(author3);



        Iterable<Book> retrievedBook = underTestBook.findAll();
        Assertions.assertThat(retrievedBook).hasSize(3).containsExactly(book1, book2, book3);

    }


    @Test
    @Transactional
    public void testBookCanBeUpdated(){
        Author author1 = TestDataUtil.getAuthor1();
        Book book1 = TestDataUtil.getBook1(author1);
        author1.addBook(book1);
        underTestAuthor.save(author1);



        Author author3 = TestDataUtil.getAuthor3();
        book1.setAuthor(author3);
        book1.setTitle("Im updated book");
        author1.removeBook(book1);
        author3.addBook(book1);
        underTestAuthor.save(author3);

        Optional<Book> result = underTestBook.findById(book1.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book1);
    }

    @Test
    @Transactional
    public void testBookCanBeDeleted(){
        Author author1 = TestDataUtil.getAuthor1();
        Book book1 = TestDataUtil.getBook1(author1);
        author1.addBook(book1);
        underTestAuthor.save(author1);

        Optional<Book> result = underTestBook.findById(book1.getIsbn());
        assertThat(result.get()).isEqualTo(book1);

        author1.removeBook(book1);
        underTestAuthor.saveAndFlush(author1);

        Optional<Book> result1 =  underTestBook.findById(book1.getIsbn());
        assertThat(result1).isEmpty();

    }

}
