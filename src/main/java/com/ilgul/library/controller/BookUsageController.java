package com.ilgul.library.controller;

import com.ilgul.library.dto.ExpiredInUseDto;
import com.ilgul.library.entity.BookHistory;
import com.ilgul.library.entity.BookInUse;
import com.ilgul.library.mapper.bookInUseMapper;
import com.ilgul.library.service.BookUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BookUsageController {

    private final BookUsageService bookUsageService;
    private final com.ilgul.library.mapper.bookInUseMapper bookInUseMapper;

    @GetMapping("/usage/expired")
    public List<ExpiredInUseDto> expired(@RequestParam(defaultValue = "${time.expired.after}") Integer minExpiredDays){
        List<BookInUse> expired = bookUsageService.getExpired(minExpiredDays);

        return expired.stream()
                .map(bookInUseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/usage/client/{clientId}/book/{bookId}")
    public BookInUse takeBook(@PathVariable Long clientId,
                              @PathVariable Long bookId){
        return bookUsageService.takeBook(clientId, bookId);
    };

    @DeleteMapping("/usage/client/{clientId}/book/{bookId}")
    public BookHistory returnBook(@PathVariable Long clientId,
                                  @PathVariable Long bookId){
      return bookUsageService.returnBook(clientId, bookId);
    };
}
