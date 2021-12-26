package com.ilgul.library.mapper;

import com.ilgul.library.dto.BookDetailsDto;
import com.ilgul.library.dto.BookSmallDto;
import com.ilgul.library.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BookSmallDto toSmall(Book book);

    BookDetailsDto toDetails(Book book);
}
