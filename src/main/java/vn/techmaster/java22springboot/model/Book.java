package vn.techmaster.java22springboot.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
}
