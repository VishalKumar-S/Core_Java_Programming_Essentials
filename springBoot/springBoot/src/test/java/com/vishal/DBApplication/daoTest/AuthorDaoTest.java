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

        verify(jdbcTemplate).query(eq("SELECT * FROM author WHERE author_id = ?"), ArgumentMatchers.<AuthorDaoImpl.authorRowMapper>any() , eq(12));
    }


    @Test
    public void testReadAll(){
        underTest.readAll();
        verify(jdbcTemplate).query(eq("SELECT * FROM author"),ArgumentMatchers.<AuthorDaoImpl.authorRowMapper>any());
    }
}
