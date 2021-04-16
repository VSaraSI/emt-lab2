package emt.lab2.demo.service;

import emt.lab2.demo.model.Book;
import emt.lab2.demo.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    
    List<Book> findAll();

    Optional<Book> findById(Long id);

    void deleteById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> save(String name, String category, Long author, Integer copies);

    Optional<Book> edit(Long id, BookDto bookDto);

    Optional<Book> edit(Long id, String name, String category, Long author, Integer copies);

    void changeCopies(Long id);
}
