package com.vishal.DBApplication.dao.Implementation;
import com.vishal.DBApplication.Author;
import com.vishal.DBApplication.dao.bookDao;
import org.springframework.jdbc.core.JdbcTemplate;
import com.vishal.DBApplication.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements bookDao{

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO book VALUES (?, ?, ?)", book.getIsbn(), book.getTitle(), book.getAuthor_id());
    }


    public static class bookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder().isbn(rs.getString("isbn")).title(rs.getString("title")).author_id(rs.getInt("author_id")).build();
        }


    }

    @Override
    public Optional<Book> readOne(String isbn){
        List<Book> bookDetails = jdbcTemplate.query("SELECT * FROM book WHERE isbn = ?", new BookDaoImpl.bookRowMapper(), isbn);
        return bookDetails.stream().findFirst();
    }

    @Override
    public List<Book> readAll(){
        return jdbcTemplate.query("SELECT * FROM book", new BookDaoImpl.bookRowMapper());
    }

    @Override
    public void update(Book book, String isbn){
        jdbcTemplate.update("UPDATE book SET title = ?, author_id = ? WHERE isbn = ?", book.getTitle(), book.getAuthor_id(), isbn);
    }
}
