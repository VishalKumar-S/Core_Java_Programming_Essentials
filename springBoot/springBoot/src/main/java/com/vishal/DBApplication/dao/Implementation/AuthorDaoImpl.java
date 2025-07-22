package com.vishal.DBApplication.dao.Implementation;
import com.vishal.DBApplication.dao.authorDao;
import com.vishal.DBApplication.Author;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorDaoImpl implements authorDao{
    private JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO author VALUES (?, ?, ?)", author.getAuthor_id(), author.getName(), author.getAge());
    }

    public static class authorRowMapper implements RowMapper<Author>{
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .author_id(rs.getInt("author_id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }

    @Override
    public Optional<Author> readOne(Integer authorID){
        List<Author> authorDetails = jdbcTemplate.query("SELECT * FROM author WHERE author_id = ?", new authorRowMapper(), authorID);
        return authorDetails.stream().findFirst();
    }

    @Override
    public List<Author> readAll(){
        return jdbcTemplate.query("SELECT * FROM author", new authorRowMapper());
    }

    @Override
    public void update(Author author, Integer authorID){
        jdbcTemplate.update("UPDATE author SET name = ?, age = ? WHERE author_id = ?", author.getName(), author.getAge(), authorID);
    }







}
