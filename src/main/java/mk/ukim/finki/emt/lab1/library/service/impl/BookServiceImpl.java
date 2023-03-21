package mk.ukim.finki.emt.lab1.library.service.impl;

import mk.ukim.finki.emt.lab1.library.models.Author;
import mk.ukim.finki.emt.lab1.library.models.Book;
import mk.ukim.finki.emt.lab1.library.models.Category;
import mk.ukim.finki.emt.lab1.library.repository.BookRepository;
import mk.ukim.finki.emt.lab1.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> edit(Long id, Book bookEdit) {
        Book book = null;
        if(findById(id).isPresent())
        {
            book = findById(id).get();
            book.setName(bookEdit.getName());
            book.setAuthor(bookEdit.getAuthor());
            book.setCategory(bookEdit.getCategory());
            book.setAvailableCopies(bookEdit.getAvailableCopies());
            save(book);
        }

        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> save(Book book) {
        return Optional.of(this.bookRepository.save(book));
    }

}
