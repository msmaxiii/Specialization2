package com.optum.capstone.Specialization.services;


import com.optum.capstone.Specialization.dtos.BookDto;
import com.optum.capstone.Specialization.entities.Customer;
import com.optum.capstone.Specialization.entities.CustomerFavBook;
import com.optum.capstone.Specialization.repositories.BookRepository;
import com.optum.capstone.Specialization.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDto> getAllBooksByUserId(Long customerId){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()){
            List<CustomerFavBook> BookList = bookRepository.findAllByCustomersEquals(customerOptional.get());
            return CustomerBookList.stream().map(book -> new BookDto(customerBook)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addBook(BookDto bookDto, Long bookId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Book book = new Book(bookDto);
        customerOptional.ifPresent(book::setCustomer);
        bookRepository.saveAndFlush(book);
    }

    @Override
    @Transactional
    public void deleteBookById(Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        bookOptional.ifPresent(book -> bookRepository.delete(book));
    }

    @Override
    @Transactional
    public void updateBookById(BookDto bookDto) {
        Optional<Book> bookOptional = bookRepository.findById(bookDto.getId());
        bookOptional.ifPresent(book -> {
            book.setBody(bookDto.getBody());
            bookRepository.saveAndFlush(note);
        });
    }

    @Override
    public Optional<BookDto> getBookById(Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isPresent()){
            return Optional.of(new BookDto(bookOptional.get()));
        }
        return Optional.empty();
    }
}
