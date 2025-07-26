package com.vishal.DBApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    private Integer author_id;
    private String name;
    private Integer age;
}
