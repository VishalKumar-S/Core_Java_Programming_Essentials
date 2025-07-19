package com.vishal.DBApplication;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class book {
    private String isbn;
    private String title;
    private Integer author_id;


}
