package com.vishal.JPAHibernate.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishal.JPAHibernate.DTO.AuthorDTO;
import com.vishal.JPAHibernate.DTO.BookDTO;
import com.vishal.JPAHibernate.DTO.BookResponseDTO;
import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.Entities.Book;
import com.vishal.JPAHibernate.TestDataUtil;
import com.vishal.JPAHibernate.services.BookService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BookService bookService;

    @Test
    @Transactional
    public void testCreateBookAndReturnsStatusCode201AndSavedBook() throws  Exception{
        BookDTO bookDTO = TestDataUtil.getBookDTO1(null);
        String bookDtoJson = objectMapper.writeValueAsString(bookDTO);
        mockMvc.perform(MockMvcRequestBuilders.put("/books/846-43484-243").contentType(MediaType.APPLICATION_JSON).content(bookDtoJson)).andExpect(MockMvcResultMatchers.status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.isbn").value(bookDTO.getIsbn())).andExpect(MockMvcResultMatchers.jsonPath("$.title").value(bookDTO.getTitle()));
    }


    @Test
    @Transactional
    public void testListBooksReturnsStatusCode200AndListOfBooks() throws Exception{
        Book book =  TestDataUtil.getBook1(null);
        bookService.saveBook(book);
        mockMvc.perform(MockMvcRequestBuilders.get("/books")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$").isArray()).andExpect(MockMvcResultMatchers.jsonPath("$[0].isbn").isString()).andExpect(MockMvcResultMatchers.jsonPath("$[0].title").isString());
    }

    @Test
    @Transactional
    public void testUpdateBookAndReturnsStatusCode200() throws  Exception{
        Book book1 = TestDataUtil.getBook1(null);
        BookDTO bookDTO2 = TestDataUtil.getBookDTO2(null);


        bookService.saveBook(book1);
        bookDTO2.setIsbn(book1.getIsbn());



        String bookDtoJson = objectMapper.writeValueAsString(bookDTO2);
        mockMvc.perform(MockMvcRequestBuilders.put("/books/"+bookDTO2.getIsbn()).contentType(MediaType.APPLICATION_JSON).content(bookDtoJson)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.isbn").value(bookDTO2.getIsbn())).andExpect(MockMvcResultMatchers.jsonPath("$.title").value(bookDTO2.getTitle()));
    }


    @Test
    @Transactional
    public void testBookCanBePartiallyUpdatedandReturnsStatusCode200AndBook() throws Exception {
        Book existingBook = TestDataUtil.getBook1(null);
        bookService.saveBook(existingBook);

        BookResponseDTO partiallyUpdatedBookResponseDTO = BookResponseDTO.builder().title("Updated via patch Integration Test").build();

        String bookDTOJson = objectMapper.writeValueAsString(partiallyUpdatedBookResponseDTO);

        mockMvc.perform(MockMvcRequestBuilders.patch("/books/{isbn}", existingBook.getIsbn()).contentType(MediaType.APPLICATION_JSON).content(bookDTOJson)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.isbn").value(existingBook.getIsbn())).andExpect(MockMvcResultMatchers.jsonPath("$.title").value(partiallyUpdatedBookResponseDTO.getTitle())).andExpect(MockMvcResultMatchers.jsonPath("$.author").value(existingBook.getAuthor()));
    }





}
