package com.vishal.JPAHibernate.mappers;

import com.vishal.JPAHibernate.DTO.BookDTO;
import com.vishal.JPAHibernate.DTO.BookResponseDTO;
import com.vishal.JPAHibernate.Entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<BookDTO, Book>{

    private final ModelMapper modelMapper;

    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Book mapTo(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }


    @Override
    public BookDTO mapFrom(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public BookResponseDTO mapBookEntitiyToResponse(Book book) {
        return modelMapper.map(book, BookResponseDTO.class);
    }

}
