package com.ilgul.library.entity;

import com.ilgul.library.dto.BookDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String description;
    private String publisher;
    private String isbn;
    private Integer year;
    private boolean available = true;

    @OneToMany(mappedBy = "book")
    @ToString.Exclude
    private List<BookHistory> bookHistories = new ArrayList<>();

    public Book(BookDto dto){
        name = dto.getName();
        author = dto.getAuthor();
        description = dto.getDescription();
        publisher = dto.getPublisher();
        isbn = dto.getIsbn();
        year = dto.getYear();
    }
}
