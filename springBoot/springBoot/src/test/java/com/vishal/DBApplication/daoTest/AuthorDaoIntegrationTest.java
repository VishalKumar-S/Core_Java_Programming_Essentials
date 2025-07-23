package com.vishal.DBApplication.daoTest;

import com.vishal.DBApplication.Author;
import com.vishal.DBApplication.dao.Implementation.AuthorDaoImpl;
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
public class AuthorDaoIntegrationTest {


    private final AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoIntegrationTest(AuthorDaoImpl underTest){
        this.underTest = underTest;
        System.out.println("\n" + "When @Autowired IS needed: \\n 1) Multiple Constructors: To explicitly tell Spring which constructor to use for dependency injection when more than one exists. This is its primary use case for constructors now. \\n 2) Field Injection: If you choose to use field injection (which is generally discouraged for required dependencies due to the reasons mentioned in the previous answer, like lack of final support, hidden dependencies, and poorer testability).\n When you run a test, you are not calling SpringApplication.run(). The JUnit test runner simply creates an instance of your test class (AuthorDaoIntegrationTest) and calls the methods annotated with @Test.By default, your test class is just a Plain Old Java Object (POJO). The Spring Framework has no idea it even exists. This is why, without @SpringBootTest, this.underTest was null. Nothing ever told Spring to start its context, scan for beans, and inject AuthorDaoImpl.@SpringBootTest is the \"on\" switch for your tests. It tells the JUnit runner:\"Hey, before you run this test, please start up a full Spring Boot application context, just like you would for the real application. Find all the beans and get them ready.\"Once the context is running, it can then perform the @Autowired injection into your test's constructor. JUnit is the testing framework. It's the engine that discovers your test classes, runs the methods annotated with @Test, and reports the results (pass or fail).•Spring Test is a module that integrates with JUnit. It provides the special annotations like @SpringBootTest and @Autowired that bring the power of the Spring context into your JUnit tests. @ExtendWith(SpringExtension.class) annotation is the bridge or the glue that connects the JUnit 5 engine to the Spring Test Framework.When JUnit 5 sees @ExtendWith(SpringExtension.class), it says, \"Okay, I won't just run this test normally. I will hand over some control to the SpringExtension.\"The SpringExtension is then responsible for:•Reading the @SpringBootTest annotation.•Starting the Spring ApplicationContext.•Handling dependency injection for your test class (e.g., calling your @Autowired constructor).•Managing the lifecycle of the test within the Spring context.In modern versions of Spring Boot, @SpringBootTest is already annotated with @ExtendWith(SpringExtension.class), so you often don't need to declare it explicitly. However, it's very good to know what it does, as it's the key piece that makes the integration work. ");
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author1 = TestDataUtil.getAuthor1();
        underTest.create(author1);

        Optional<Author> retrievedAuthor = underTest.readOne(12);
        assertThat(retrievedAuthor).isPresent();
        assertThat(retrievedAuthor.get()).isEqualTo(author1);
    }


    @Test
    public void testAuthorsCanBeCreatedAndRecalled(){
        Author author1 = TestDataUtil.getAuthor1();
        underTest.create(author1);

        Author author2 = TestDataUtil.getAuthor2();
        underTest.create(author2);

        Author author3 = TestDataUtil.getAuthor3();
        underTest.create(author3);

        List<Author> retrievedAuthor = underTest.readAll();
        assertThat(retrievedAuthor).hasSize(3).containsExactly(author1, author2, author3);

    }


    @Test
    public void TestAuthorCanBeUpdated(){
        Author author1 = TestDataUtil.getAuthor1();
        underTest.create(author1);

        author1.setAge(70);
        author1.setName("Im updated author");
        underTest.update(author1, 12);

        Optional<Author> retrievedAuthor = underTest.readOne(12);
        assertThat(retrievedAuthor).isPresent();
        assertThat(retrievedAuthor.get()).isEqualTo(author1);
    }


    @Test
    public void TestAuthorCanBeDeleted(){
        Author author1 = TestDataUtil.getAuthor1();
        underTest.create(author1);

        underTest.delete(author1, 12);

        Optional<Author> retrievedAuthor = underTest.readOne(12);
        assertThat(retrievedAuthor).isEmpty();
    }


}
