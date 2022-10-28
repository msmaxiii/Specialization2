package com.optum.capstone.Specialization.controller;

import com.optum.capstone.Specialization.services.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private BookService bookService;

    }

