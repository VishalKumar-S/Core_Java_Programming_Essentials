package com.vishal.JPAHibernate.config;


import com.vishal.JPAHibernate.DTO.AuthorDTO;
import com.vishal.JPAHibernate.DTO.AuthorResponseDTO;
import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

//    Mapper maps the getter method of the source class's field to the destination class field's setter
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Author.class, AuthorDTO.class).addMapping(Author::getAuthorName, AuthorDTO::setName).addMapping(Author::getAge, AuthorDTO::setAge);

        modelMapper.createTypeMap(Author.class, AuthorResponseDTO.class).addMapping(Author::getAuthorName, AuthorResponseDTO::setName).addMapping(Author::getAge, AuthorResponseDTO::setAge);


    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper;
    }
}
