package com.vishal.DBApplication.daoTest;

import com.vishal.DBApplication.Author;
import com.vishal.DBApplication.Book;
import com.vishal.DBApplication.dao.Implementation.AuthorDaoImpl;
import com.vishal.DBApplication.dao.Implementation.BookDaoImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoIntegrationTest {
    private final BookDaoImpl underTestBook;
    private final AuthorDaoImpl underTestAuthor;

    @Autowired
    public BookDaoIntegrationTest(BookDaoImpl underTestBook, AuthorDaoImpl underTestAuthor){
        System.out.println("Spring considers each test to be isolated and dependent, so after test completes, all the transactions made in the DB woudl be rolled back by Spring, to avoid conflict with other tests, working in the same db. So, if a schema has some constraint/referene with other schema, u should create that referential instance again here, since each test is isoalted and independent. WHen wee excute the whole class,which osnosts f integration tests, duplciateekyexception error wodula rise, if multiple test use ssmae instance creation, so using DIrtiestContext annotation, afte reach test completion, the entire spring context is removed and resetted again, so it would be rollbacked after test completes");
        this.underTestBook = underTestBook;
        this.underTestAuthor = underTestAuthor;

    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author1 = TestDataUtil.getAuthor1();
        underTestAuthor.create(author1);

        Book book1 = TestDataUtil.getBook1();
        underTestBook.create(book1);
        Optional<Book> result = underTestBook.readOne(book1.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book1);
    }


    @Test
    public void testBooksCanBeCreatedAndRecalled(){
        Author author1 = TestDataUtil.getAuthor1();
        underTestAuthor.create(author1);
        Book book1 = TestDataUtil.getBook1();
        underTestBook.create(book1);

        Author author2 = TestDataUtil.getAuthor2();
        underTestAuthor.create(author2);
        Book book2 = TestDataUtil.getBook2();
        underTestBook.create(book2);

        Author author3 = TestDataUtil.getAuthor3();
        underTestAuthor.create(author3);
        Book book3 = TestDataUtil.getBook3();
        underTestBook.create(book3);


        List<Book> retrievedBook = underTestBook.readAll();
        Assertions.assertThat(retrievedBook).hasSize(3).containsExactly(book1, book2, book3);

    }


    @Test
    public void testBookCanBeUpdated(){
        Author author1 = TestDataUtil.getAuthor1();
        underTestAuthor.create(author1);

        Book book1 = TestDataUtil.getBook1();
        underTestBook.create(book1);


        Author author3 = TestDataUtil.getAuthor3();
        underTestAuthor.create(author3);
        book1.setAuthor_id(author3.getAuthor_id());
        book1.setTitle("Im updated book");
        underTestBook.update(book1, book1.getIsbn());

        Optional<Book> result = underTestBook.readOne(book1.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book1);
    }

    @Test
    public void testBookCanBeDeleted(){
        Author author1 = TestDataUtil.getAuthor1();
        underTestAuthor.create(author1);

        Book book1 = TestDataUtil.getBook1();
        underTestBook.create(book1);

        underTestBook.delete(book1, book1.getIsbn());
        Optional<Book> result =  underTestBook.readOne(book1.getIsbn());
        assertThat(result).isEmpty();

    }

}
