package com.vishal.DBApplication.dao.Implementation;
import com.vishal.DBApplication.dao.authorDao;
import com.vishal.DBApplication.author;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.RowMapper;

public class authorDaoImpl implements authorDao{
    private JdbcTemplate jdbcTemplate;

    public authorDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(author author) {
        jdbcTemplate.update("INSERT INTO author VALUES (?, ?, ?)", author.getAuthor_id(), author.getName(), author.getAge());
    }

    public static class authorRowMapper implements RowMapper<author>{
        @Override
        public author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return author.builder()
                    .author_id(rs.getInt("author_id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }


    }

    @Override
    public Optional<author> readOne(Integer authorID){
        List<author> authorDetails = jdbcTemplate.query("SELECT * FROM author WHERE author_id = ?", new authorRowMapper(), authorID);
        return authorDetails.stream().findFirst();
    }


}
