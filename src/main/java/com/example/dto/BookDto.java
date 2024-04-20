package com.example.dto;

import io.micronaut.serde.annotation.SerdeImport;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Builder
@SerdeImport(BookDto.class)
public class BookDto {
    private String bookTitle;
    private int totalPages;
}
