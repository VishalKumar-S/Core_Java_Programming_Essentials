package com.vishal.DBApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class book {
    private String isbn;
    private String title;
    private Integer author_id;


}
