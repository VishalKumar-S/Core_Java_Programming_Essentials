package com.vishal.JPAHibernate.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishal.JPAHibernate.DTO.AuthorDTO;
import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.TestDataUtil;
import com.vishal.JPAHibernate.services.AuthorService;
import com.vishal.JPAHibernate.services.BookService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * This is a full integration test for the AuthorController.
 *
 * @SpringBootTest loads the complete Spring application context.
 * @AutoConfigureMockMvc provides and configures a MockMvc instance for sending
 * requests to the application without needing a running web server.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthorService authorService;

/*   Best Practice:
      * Application Code: Use Constructor Injection.•
      * Test Code: Use Field Injection.

     MockMvc is a testing framework that allows you to send mock HTTP requests into your Spring application's DispatcherServlet and assert the results.
  */



    /**
     * The below test verifies the full flow of the createAuthor endpoint.
     * It sends a mock HTTP request with an AuthorDTO, asserts that the response
     * status is 201 Created, and validates the content of the returned JSON body.
     * The @Transactional annotation ensures any database changes are rolled back
     * after the test, providing a clean state for subsequent tests.
     */
    @Test
    @Transactional
    public void testCreateAuthorReturnsStatusCode201AndSavedAuthor() throws Exception {

        AuthorDTO authorDTO = TestDataUtil.getAuthorDTO1();
        String authorDtoJson = objectMapper.writeValueAsString(authorDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/authors").contentType(MediaType.APPLICATION_JSON).content(authorDtoJson)).andExpect(MockMvcResultMatchers.status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.author_id").isNumber()).andExpect(MockMvcResultMatchers.jsonPath("$.name").value(authorDTO.getName())).andExpect(MockMvcResultMatchers.jsonPath("$.vayasu").value(authorDTO.getAge()));
    }






    @Test
    @Transactional
    public void testListAuthorsReturnsStatusCode200AndListOfAuthors() throws Exception {

        Author author = TestDataUtil.getAuthor1();
        authorService.saveAuthor(author);

        mockMvc.perform(MockMvcRequestBuilders.get("/authors")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$").isArray()).andExpect(MockMvcResultMatchers.jsonPath("$[0].author_id").isNumber()).andExpect(MockMvcResultMatchers.jsonPath("$[0].name").isString());
    }

    @Test
    @Transactional
    public void testAuthorCanBeReadandReturnsStatusCode200AndAuthor() throws Exception {
        Author author = TestDataUtil.getAuthor1();
        authorService.saveAuthor(author);
        mockMvc.perform(MockMvcRequestBuilders.get("/authors/{id}", author.getAuthor_id())).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.author_id").value(author.getAuthor_id())).andExpect(MockMvcResultMatchers.jsonPath("$.name").value(author.getAuthorName())).andExpect(MockMvcResultMatchers.jsonPath("$.vayasu").value(author.getAge()));
    }


    @Test
    @Transactional
    public void testAuthorCanBePartiallyUpdatedandReturnsStatusCode200AndAuthor() throws Exception {
        Author existingAuthor = TestDataUtil.getAuthor1();
        authorService.saveAuthor(existingAuthor);

        AuthorDTO partiallyUpdatedauthorDTO = AuthorDTO.builder().name("Updated via patch Integration Test").build();

        String authorDtoJson = objectMapper.writeValueAsString(partiallyUpdatedauthorDTO);

        mockMvc.perform(MockMvcRequestBuilders.patch("/authors/{id}", existingAuthor.getAuthor_id()).contentType(MediaType.APPLICATION_JSON).content(authorDtoJson)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.author_id").value(existingAuthor.getAuthor_id())).andExpect(MockMvcResultMatchers.jsonPath("$.name").value(partiallyUpdatedauthorDTO.getName())).andExpect(MockMvcResultMatchers.jsonPath("$.vayasu").value(existingAuthor.getAge()));
    }




    }

