package mk.ukim.finki.emt.lab1.library.service;

import mk.ukim.finki.emt.lab1.library.models.Author;
import mk.ukim.finki.emt.lab1.library.models.Book;
import mk.ukim.finki.emt.lab1.library.models.Category;
import mk.ukim.finki.emt.lab1.library.models.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(BookDto book);
    Optional<Book> edit(Long id, BookDto book);
    void deleteById(Long id);
    void markBook(Long id);
    void addBooks();
}
