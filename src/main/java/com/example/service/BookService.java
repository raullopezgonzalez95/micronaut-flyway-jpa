package com.example.service;

import com.example.dto.BookDto;
import com.example.entities.BookEntity;
import com.example.repository.BookRepository;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<BookDto> findAll() {
        var data = bookRepository.findAll();
        return data.stream()
                .map(book -> BookDto.builder()
                        .bookTitle(book.getBookTitle())
                        .totalPages(book.getTotalPages())
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public BookDto findById(Long id) {
        var data = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book not found")
        );

        return BookDto.builder()
                .bookTitle(data.getBookTitle())
                .totalPages(data.getTotalPages())
                .build();
    }

    public BookDto createBook(BookDto bookDto) {
        var bookEntity = new BookEntity();
        bookEntity.setBookTitle(bookDto.getBookTitle());
        bookEntity.setTotalPages(bookDto.getTotalPages());

        var book = bookRepository.save(bookEntity);

        return BookDto.builder()
                .bookTitle(book.getBookTitle())
                .totalPages(book.getTotalPages())
                .build();
    }

    public BookDto updateBook(Long id, BookDto bookDto) {
        var data = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book not found")
        );

        data.setBookTitle(bookDto.getBookTitle());
        data.setTotalPages(bookDto.getTotalPages());

        var book = bookRepository.save(data);

        return BookDto.builder()
                .bookTitle(book.getBookTitle())
                .totalPages(book.getTotalPages())
                .build();
    }
}
