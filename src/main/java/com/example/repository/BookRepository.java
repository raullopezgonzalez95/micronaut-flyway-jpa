package com.example.repository;

import com.example.entities.BookEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
