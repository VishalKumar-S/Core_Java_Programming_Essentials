package com.vishal.JPAHibernate.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishal.JPAHibernate.DTO.AuthorDTO;
import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.TestDataUtil;
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




    }

