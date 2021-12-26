package com.ilgul.library.dto;

import com.ilgul.library.entity.Book;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookInUseDto {
    //TODO replace entity by dto
    private Book book;
    private LocalDate inUseFrom;
}
