package com.vishal.DBApplication.daoTest;
import com.vishal.DBApplication.dao.Implementation.AuthorDaoImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import com.vishal.DBApplication.Author;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testCreateAuthor() {
        Author author = TestDataUtil.getAuthor1();
        underTest.create(author);

        verify(jdbcTemplate).update(eq("INSERT INTO author VALUES (?, ?, ?)"), eq(12), eq("vishal"), eq(1));
    }

    @Test
    public void testReadAuthor() {
        underTest.readOne(12);

        verify(jdbcTemplate).query(eq("SELECT * FROM author WHERE author_id = ?"), ArgumentMatchers.<AuthorDaoImpl.authorRowMapper>any(), eq(12));
    }


    @Test
    public void testReadAll() {
        underTest.readAll();
        verify(jdbcTemplate).query(eq("SELECT * FROM author"), ArgumentMatchers.<AuthorDaoImpl.authorRowMapper>any());
    }

    @Test
    public void testUpdateAuthor() {
        Author author = TestDataUtil.getAuthor1();
        author.setAge(70);
        author.setName("Im updated author");
        underTest.update(author, 12);
        verify(jdbcTemplate).update(eq("UPDATE author SET name = ?, age = ? WHERE author_id = ?"), eq("Im updated author"), eq(70), eq(12));
    }


    @Test
    public void deleteAuthor(){
        underTest.delete(TestDataUtil.getAuthor1(), 12);
        verify(jdbcTemplate).update(eq("DELETE FROM author WHERE author_id = ?"), eq(12));
    }
}
