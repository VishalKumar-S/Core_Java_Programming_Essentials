package com.vishal.DBApplication;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private String isbn;
    private String title;
    private Integer author_id;


}
