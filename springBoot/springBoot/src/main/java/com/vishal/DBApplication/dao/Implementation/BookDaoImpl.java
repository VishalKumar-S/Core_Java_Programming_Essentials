package com.vishal.DBApplication.dao.Implementation;
import com.vishal.DBApplication.author;
import com.vishal.DBApplication.dao.bookDao;
import org.springframework.jdbc.core.JdbcTemplate;
import com.vishal.DBApplication.book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookDaoImpl implements bookDao{

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(book book) {
        jdbcTemplate.update("INSERT INTO book VALUES (?, ?, ?)", book.getIsbn(), book.getTitle(), book.getAuthor_id());
    }


    public static class bookRowMapper implements RowMapper<book> {
        @Override
        public book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return book.builder().isbn(rs.getString("isbn")).title(rs.getString("title")).author_id(rs.getInt("author_id")).build();
        }


    }

    @Override
    public Optional<book> readOne(String isbn){
        List<book> bookDetails = jdbcTemplate.query("SELECT * FROM book WHERE isbn = ?", new BookDaoImpl.bookRowMapper(), isbn);
        return bookDetails.stream().findFirst();
    }
}
