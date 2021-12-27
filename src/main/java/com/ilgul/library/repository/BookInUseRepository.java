package com.ilgul.library.repository;

import com.ilgul.library.entity.Book;
import com.ilgul.library.entity.BookInUse;
import com.ilgul.library.entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookInUseRepository extends PagingAndSortingRepository<BookInUse, Long> {

    Optional<BookInUse> findByClientAndBook(Client client, Book book);

    List<BookInUse> findByInUseFromBefore(LocalDate inUseFromBefore);
}
