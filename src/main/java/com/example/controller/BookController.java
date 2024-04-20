package com.example.controller;

import com.example.dto.BookDto;
import com.example.service.BookService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Controller("/books")
public class BookController {
    private final BookService bookService;

    @Get("/all")
    public List<BookDto> findAll() {
        return bookService.findAll();
    }

    @Get("/{id}")
    public BookDto findById(@PathVariable Long id) {
        return bookService.findById(id);
    }
}
