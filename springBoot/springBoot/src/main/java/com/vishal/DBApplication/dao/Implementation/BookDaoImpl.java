package com.vishal.DBApplication.dao.Implementation;
import com.vishal.DBApplication.dao.bookDao;
import org.springframework.jdbc.core.JdbcTemplate;
import com.vishal.DBApplication.book;

public class BookDaoImpl implements bookDao{

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(book book) {
        jdbcTemplate.update("INSERT INTO book VALUES (?, ?, ?)", book.getIsbn(), book.getTitle(), book.getAuthor_id());
    }
}
