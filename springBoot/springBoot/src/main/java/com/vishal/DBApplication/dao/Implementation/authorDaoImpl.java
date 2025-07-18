package com.vishal.DBApplication.dao.Implementation;
import com.vishal.DBApplication.dao.authorDao;
import com.vishal.DBApplication.author;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;

public class authorDaoImpl implements authorDao{
    private JdbcTemplate jdbcTemplate;

    public authorDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(author author) {
        jdbcTemplate.update("INSERT INTO author VALUES (?, ?, ?)", author.getAuthor_id(), author.getName(), author.getAge());
    }
}
