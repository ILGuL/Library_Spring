package com.ilgul.library.repository;

import com.ilgul.library.entity.BookHistory;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookHistoryRepository extends PagingAndSortingRepository<BookHistory, Long> {
}
