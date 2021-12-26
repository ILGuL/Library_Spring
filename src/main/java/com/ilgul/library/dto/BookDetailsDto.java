package com.ilgul.library.dto;

import com.ilgul.library.entity.BookHistory;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookDetailsDto extends BookSmallDto{
    private List<BookHistoryDto> bookHistories;
}
