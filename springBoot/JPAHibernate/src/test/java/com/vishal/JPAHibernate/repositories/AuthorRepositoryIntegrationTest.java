package com.vishal.JPAHibernate.repositories;

import com.vishal.JPAHibernate.Book;
import com.vishal.JPAHibernate.TestDataUtil;
import com.vishal.JPAHibernate.Author;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class AuthorRepositoryIntegrationTest {


    private final AuthorRepository underTestAuthor;
    private final BookRepository underTestBook;

    @Autowired
    public AuthorRepositoryIntegrationTest(AuthorRepository underTestAuthor, BookRepository underTestBook){
        this.underTestAuthor = underTestAuthor;
        this.underTestBook = underTestBook;

        System.out.println("Within a Spring @Transactional method, Hibernate uses a powerful mechanism called the Persistence Context, which acts as a smart, in-memory cache for all the database entities it's managing. A common misconception is that every repository call immediately results in a database operation. Instead, for efficiency, Hibernate queues up INSERT, UPDATE, and DELETE statements and typically only executes them against the database when the transaction is about to commit. The key to understanding different deletion behaviors lies in how your actions change an entity's state within this context.When an entity is loaded, its state is MANAGED. When you trigger a deletion, its state transitions to REMOVED. However, how and why it enters this state makes all the difference, leading to two distinct scenarios seen in your tests:1.Indirect Deletion via orphanRemoval (The Book Test): When you remove a Book from its Author's list (author.removeBook(book)), you are not directly telling Hibernate to delete it. You are simply modifying a Java collection. Hibernate detects this change and, because of the orphanRemoval = true setting, interprets the Book as an orphan. It then changes the Book object's state in the Persistence Context from MANAGED to REMOVED. However, because this was an indirect action, the context keeps this \"zombie\" object in its cache. If you immediately call findById() for that book, the context finds the object in its cache and returns it, even though it's marked for deletion. This causes your assertion (assertThat(result).isEmpty()) to fail. To correctly test this, you must explicitly force the queued DELETE statement to be sent to the database by calling saveAndFlush(). This synchronizes the database with the context's state, ensuring a subsequent findById() will find nothing.2.Direct Deletion via deleteById with Cascade (The Author Test): When you call authorRepository.deleteById(), you are giving a direct, explicit, and unambiguous command: \"Destroy this Author and everything associated with it.\" Hibernate honors this strong intent differently. It immediately transitions the Author's state to REMOVED. Then, because of cascade = CascadeType.ALL, it immediately cascades this state transition to all child Book objects in the collection, also changing their state to REMOVED. Now, the entire object graph is marked for destruction within the context. When you subsequently call findById() for either the Author or any of its Books, the Persistence Context respects the direct \"destroy\" command it received and immediately returns Optional.empty(), without needing to consult the database. This is why the assertions pass without an explicit flush; the context's internal state is already consistent with the definitive deletion command you issued.\n");
    }

    @Test
    @Transactional
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author1 = TestDataUtil.getAuthor1();
        underTestAuthor.save(author1);

        Optional<Author> retrievedAuthor = underTestAuthor.findById(author1.getAuthor_id());
        assertThat(retrievedAuthor).isPresent();
        assertThat(retrievedAuthor.get()).isEqualTo(author1);


    }


    @Test
    @Transactional
    public void testAuthorsCanBeCreatedAndRecalled(){
        Author author1 = TestDataUtil.getAuthor1();
        underTestAuthor.save(author1);

        Author author2 = TestDataUtil.getAuthor2();
        underTestAuthor.save(author2);

        Author author3 = TestDataUtil.getAuthor3();
        underTestAuthor.save(author3);

        List<Author> retrievedAuthor = underTestAuthor.findAll();
        assertThat(retrievedAuthor).hasSize(3).containsExactlyInAnyOrder(author1, author2, author3);

    }


    @Test
    @Transactional
    public void TestAuthorCanBeUpdated(){
        Author author1 = TestDataUtil.getAuthor1();
        underTestAuthor.save(author1);

        author1.setAge(70);
        author1.setName("Im updated author");
        underTestAuthor.save(author1);

        Optional<Author> retrievedAuthor = underTestAuthor.findById(author1.getAuthor_id());
        assertThat(retrievedAuthor).isPresent();
        assertThat(retrievedAuthor.get()).isEqualTo(author1);
    }


    @Test
    public void TestAuthorCanBeDeleted(){
        Author author1 = TestDataUtil.getAuthor1();
        underTestAuthor.save(author1);

        underTestAuthor.delete(author1);

        Optional<Author> retrievedAuthor = underTestAuthor.findById(author1.getAuthor_id());
        assertThat(retrievedAuthor).isEmpty();
    }

    @Test
    @Transactional
    public void testThatDeletingAuthorCascadesToDeleteBooks() {
        // Arrange: Create an author with a book and save it.
        Author author = TestDataUtil.getAuthor1();
        Book book = TestDataUtil.getBook1(author);
        author.addBook(book);
        underTestAuthor.save(author);

        // Sanity check: ensure the book was saved.
        assertThat(underTestBook.findById(book.getIsbn())).isPresent();

        // Act: Delete the parent Author.
        underTestAuthor.deleteById(author.getAuthor_id());

        // Assert: Verify that both the Author and their Book are gone.
        assertThat(underTestAuthor.findById(author.getAuthor_id())).isEmpty();
        assertThat(underTestBook.findById(book.getIsbn())).isEmpty();
    }


}
