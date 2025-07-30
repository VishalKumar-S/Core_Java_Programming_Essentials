package com.vishal.JPAHibernate.mappers;

import com.vishal.JPAHibernate.DTO.AuthorDTO;
import com.vishal.JPAHibernate.Entities.Author;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements Mapper<AuthorDTO, Author>{

    private ModelMapper modelMapper;

    public AuthorMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }



    @Override
    public Author mapTo(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO, Author.class);
    }

    @Override
    public AuthorDTO mapFrom(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

}
