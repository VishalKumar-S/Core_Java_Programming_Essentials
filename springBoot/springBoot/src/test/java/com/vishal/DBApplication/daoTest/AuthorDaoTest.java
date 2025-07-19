package com.vishal.DBApplication.daoTest;
import com.vishal.DBApplication.dao.Implementation.authorDaoImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import com.vishal.DBApplication.author;
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
    private authorDaoImpl underTest;

    @Test
    public void testCreateAuthor() {
        author author = new author(12, "vishal", 1);
        underTest.create(author);

        verify(jdbcTemplate).update(eq("INSERT INTO author VALUES (?, ?, ?)"), eq(1L), eq("vishal"), eq(1));
    }

    @Test
    public void testReadAuthor() {
        underTest.readOne(12);

        verify(jdbcTemplate).query(eq("SELECT * FROM author WHERE author_id = ?"), ArgumentMatchers.<authorDaoImpl.authorRowMapper>any() , eq(12));
    }
}
