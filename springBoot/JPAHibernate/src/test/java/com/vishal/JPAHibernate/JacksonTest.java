package com.vishal.JPAHibernate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishal.JPAHibernate.Entities.Author;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class JacksonTest  {

    public JacksonTest(){
        System.out.println("SpringbOot uses Jackson library to convert json to oject and vice-versa, whiel we are interacting with apie endpoints, it uses jackson library to do this conversion automatiacally. It uses ObjectMapper to do the conversion, we will uses obejctmapper and create tests. IF suppose, we get some field or atttibute extra inteh  received jso fromt eh user, whcih is not in the object structure, then we can use IgnoreProerpties to ignore that field,w hcil creatign java obejct formt ehat json sttucutre and it's posisebl to have rename naem fo an field inteh json string, by having jsonproeprtt annotitaon of th new name, above the field name.");
    }
    @Test
    public void objectToJson() throws JsonProcessingException {
        Author author1 = TestDataUtil.getAuthor1();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(author1);

        assertThat(json).isEqualTo("{\"author_id\":null,\"name\":\"vishal\",\"books\":[],\"vayasu\":1}");
    }

    @Test
    public void jsonToObject() throws JsonProcessingException{
        String json = "{\"author_id\":null,\"name\":\"vishal\",\"vayasu\":1,\"books\":[]}";
        ObjectMapper objectMapper = new ObjectMapper();
        Author result = objectMapper.readValue(json, Author.class);

        Author author1 = TestDataUtil.getAuthor1();
        assertThat(result).isEqualTo(author1);



        String jsonExtraFieldWithAliasField = "{\"unknown_key\":null,\"author_id\":null,\"name\":\"vishal\",\"vayasu\":1,\"books\":[]}";
        Author result1 = objectMapper.readValue(jsonExtraFieldWithAliasField, Author.class);
        assertThat(result1).isEqualTo(author1);


    }

}
