package com.ilgul.library.controller;

import com.ilgul.library.dto.BookDetailsDto;
import com.ilgul.library.dto.BookDto;
import com.ilgul.library.dto.BookSmallDto;
import com.ilgul.library.entity.Book;
import com.ilgul.library.mapper.BookMapper;
import com.ilgul.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;


    @GetMapping("/book")
    public Page<BookSmallDto> getAllBooks(@RequestParam Integer page,
                                          @RequestParam Integer size,
                                          @RequestParam(required = false) String query){
        Pageable pageable = PageRequest.of(page, size);
        final Page<Book> books = bookService.getAll(query, pageable);
        final List<BookSmallDto> dtos = books.get()
                .map(bookMapper::toSmall)
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, books.getTotalElements());
    }

    @GetMapping("/book/{id}")
    public BookDetailsDto getBookById(@PathVariable Long id){
        return bookMapper.toDetails(bookService.get(id));
    }

    @PostMapping("/book")
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookSmallDto createBook(@Valid @RequestBody BookDto dto) {
        return bookMapper.toSmall(bookService.create(dto));
    }

    @PutMapping("/book/{id}")
    public BookSmallDto editBook(@PathVariable Long id, @Valid @RequestBody BookDto dto) {
        return bookMapper.toSmall(bookService.update(id, dto));
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }





}
