package com.optum.capstone.Specialization.services;

import com.optum.capstone.Specialization.dtos.BookDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> getAllBooksByUserId(Long customerId);

    @Transactional
    void addBook(BookDto bookDto, Long bookId);

    @Transactional
    void deleteBookById(Long bookId);

    @Transactional
    void updateBookById(BookDto bookDto);

    Optional<BookDto> getBookById(Long bookId);
}
