package com.vishal.JPAHibernate.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorResponseDTO {
    private Integer author_id;

    private String name;

    @JsonProperty("vayasu")
    private Integer age;

}
