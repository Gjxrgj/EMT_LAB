package mk.ukim.finki.emt.lab1.library.service;

import mk.ukim.finki.emt.lab1.library.models.Author;
import mk.ukim.finki.emt.lab1.library.models.Book;
import mk.ukim.finki.emt.lab1.library.models.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(Book book);
    Optional<Book> edit(Long id, Book book);
    void deleteById(Long id);
}
