package com.vishal.DBApplication.daoTest;
import com.vishal.DBApplication.dao.Implementation.AuthorDaoImpl;
import com.vishal.DBApplication.dao.Implementation.BookDaoImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import com.vishal.DBApplication.Book;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testCreateBook() {
        Book book = TestDataUtil.getBook1();
        underTest.create(book);

        verify(jdbcTemplate).update(eq("INSERT INTO book VALUES (?, ?, ?)"), eq("846-43484-243"), eq("The aware"), eq(12));
    }


    @Test
    public void testReadBook() {
        underTest.readOne("846-43484-243");

        verify(jdbcTemplate).query(eq("SELECT * FROM book WHERE isbn = ?"), ArgumentMatchers.<BookDaoImpl.bookRowMapper>any(),eq("846-43484-243"));
    }

    @Test
    public void testReadAll(){
        underTest.readAll();
        verify(jdbcTemplate).query(eq("SELECT * FROM book"), ArgumentMatchers.<BookDaoImpl.bookRowMapper>any());
    }
}
