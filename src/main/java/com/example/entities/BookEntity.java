package com.example.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
@Entity(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long bookId;

    @Column(name = "title")
    private String bookTitle;

    @Column(name = "pages")
    private int totalPages;
}
