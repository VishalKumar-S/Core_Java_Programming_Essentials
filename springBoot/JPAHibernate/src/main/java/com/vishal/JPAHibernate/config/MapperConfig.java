package com.vishal.JPAHibernate.config;


import com.vishal.JPAHibernate.DTO.AuthorDTO;
import com.vishal.JPAHibernate.Entities.Author;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Author.class, AuthorDTO.class).addMapping(Author::getAuthorName, AuthorDTO::setName).addMapping(Author::getAge, AuthorDTO::setAge);
        return modelMapper;
    }
}
