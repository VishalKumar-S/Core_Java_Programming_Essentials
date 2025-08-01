package com.vishal.JPAHibernate.Controllers;


import com.vishal.JPAHibernate.DTO.AuthorDTO;
import com.vishal.JPAHibernate.DTO.BookDTO;
import com.vishal.JPAHibernate.Entities.Author;
import com.vishal.JPAHibernate.Entities.Book;
import com.vishal.JPAHibernate.mappers.AuthorMapper;
import com.vishal.JPAHibernate.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private final AuthorMapper authorMapper;
    private final AuthorService authorService;

    public AuthorController(AuthorMapper authorMapper, AuthorService authorService){
        this.authorMapper = authorMapper;
        this.authorService = authorService;
    }

    /**
     * The AuthorController is responsible for handling all HTTP requests related to Author resources.
     * It acts as the "presentation layer," interacting with the outside world via a REST API.
     *
     * =================================================================================================
     * The Importance of the DTO (Data Transfer Object) Pattern
     * =================================================================================================
     *
     * Q: What is a DTO and why do we use it?
     * A: A DTO (like {com.vishal.JPAHibernate.DTO.AuthorDTO}) is a simple object whose only purpose is to transfer data between
     * different layers of an application, specifically between our internal database structure (Entities)
     * and our public-facing API. We use it to create a "decoupling" or a protective shield, which
     * isolates our persistence layer from the presentation layer.
     *
     * Q: What if we didn't have a DTO?
     * A: If we returned the {com.vishal.JPAHibernate.Entities.Author} Entity directly from this controller, our API's structure would
     * be tightly coupled to our database schema. Any change in the database would immediately break our API
     * and any clients (like a frontend application) that depend on it.
     *
     * --- A Real-World Scenario ---
     * Imagine our frontend team has built a UI that expects an author object with a "name" field.
     * Later, our database administrators decide that for consistency, the 'name' column in the 'author'
     * table must be renamed to 'author_name'.
     *
     *   - WITHOUT DTO: We would change the field in our {com.vishal.JPAHibernate.Entities.Author} entity to 'authorName'. The next
     *     time we deploy, our API would start returning JSON with `{"authorName": "..."}` instead of
     *     `{"name": "..."}`. The frontend application would break because it's still looking for the 'name' field.
     *
     *   - WITH DTO: We keep the {com.vishal.JPAHibernate.DTO.AuthorDTO} stable with its public 'name' field. We only change the
     *     {com.vishal.JPAHibernate.Entities.Author} entity to have 'authorName'. The API contract remains unchanged. The magic happens
     *     in the mapping layer.
     *
     * =================================================================================================
     * The Roles of ModelMapper vs. Jackson
     * =================================================================================================
     *
     * It's crucial to understand that two different libraries handle object conversions at different stages:
     *
     * 1. ModelMapper (The Internal Java-to-Java Mapper):
     *    - Its job is to map one Java object to another (e.g., `AuthorDTO` -> `Author` entity).
     *    - It is COMPLETELY BLIND to JSON annotations like `@JsonProperty`. It only cares about Java
     *      field and method names.
     *    - In our application, the `Author` entity has a field `authorName`, but the `AuthorDTO` has `name`.
     *      ModelMapper would fail to map this by default. We solve this by providing an explicit rule in
     *      {com.vishal.JPAHibernate.config.MapperConfig}:
     *      `...addMapping(Author::getAuthorName, AuthorDTO::setName)`
     *      This tells ModelMapper exactly how to bridge the gap between the different field names.
     *
     * 2. Jackson (The External JSON-to-Java Mapper):
     *    - Its job is to work at the "edge" of the API, converting incoming JSON strings to Java objects
     *      (deserialization) and outgoing Java objects to JSON strings (serialization).
     *    - It is the ONLY library that understands and respects `@JsonProperty`.
     *    - When our controller returns an `AuthorDTO`, Jackson sees the `@JsonProperty("vayasu")` on the
     *      `age` field and ensures the final JSON response contains `{"vayasu": 21}`.
     *
     * =================================================================================================
     * Development Tip: "Why isn't my @JsonProperty change working?"
     * =================================================================================================
     *
     * When you run your application, it executes the compiled `.class` files from the `target` directory,
     * not your `.java` source files directly. If you make a change to an annotation (like adding
     * `@JsonProperty`) and your IDE doesn't automatically recompile, you might be running old code.
     *
     * The running application will use the old `.class` file without the annotation, leading to confusing
     * behavior (e.g., the JSON still shows `"age"` instead of `"vayasu"`).
     *
     * The most reliable way to fix this is to force a full rebuild:
     * 1. Stop the application.
     * 2. Run `mvn clean` in your terminal. This deletes the entire `target` directory.
     * 3. Restart the application. This will create fresh `.class` files from your latest source code.
     *
     */
    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO){

//        Here, we return ResponseEntity instead of directly AuthorDTO, because although http status code for successful creation is 201, but spring returns only 200 as response code, so while we are performing test, our test would fail, by usin ResponseEntity, we can control the response code being returned

        Author retrievedAuthor = authorMapper.mapTo(authorDTO);
        Author savedAuthor = authorService.saveAuthor(retrievedAuthor);
        return new ResponseEntity<>(authorMapper.mapFrom(savedAuthor), HttpStatus.CREATED);
    }


    @GetMapping(path = "/authors")
    public List<AuthorDTO> listAuthors(){
        List<Author> authors = authorService.findAll();
        return authors.stream().map(authorMapper::mapFrom).toList();
    }



}
