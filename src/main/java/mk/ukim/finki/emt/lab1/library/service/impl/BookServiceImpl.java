package mk.ukim.finki.emt.lab1.library.service.impl;

import mk.ukim.finki.emt.lab1.library.models.Author;
import mk.ukim.finki.emt.lab1.library.models.Book;
import mk.ukim.finki.emt.lab1.library.models.Category;
import mk.ukim.finki.emt.lab1.library.models.dto.BookDto;
import mk.ukim.finki.emt.lab1.library.repository.AuthorRepository;
import mk.ukim.finki.emt.lab1.library.repository.BookRepository;
import mk.ukim.finki.emt.lab1.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
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
    public Optional<Book> edit(Long id, BookDto bookEdit) {
        Book book = null;
        Author author = authorRepository.findById(bookEdit.getAuthor()).get();
        if(findById(id).isPresent())
        {
            book = findById(id).get();
            book.setName(bookEdit.getName());
            book.setAuthor(author);
            book.setCategory(bookEdit.getCategory());
            book.setAvailableCopies(bookEdit.getAvailableCopies());
            bookRepository.save(book);
        }

        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void markBook(Long id) {
        if(bookRepository.findById(id).isPresent())
        {
            Book book = bookRepository.findById(id).get();
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
        }
    }

    @Override
    public void addBooks() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("War and peace");
        book1.setAuthor(authorRepository.getById(1L));
        book1.setCategory(Category.DRAMA);
        book1.setAvailableCopies(15);
        Book book2 = new Book();
        book2.setId(2L);
        book2.setName("Rabies");
        book2.setAuthor(authorRepository.getById(2L));
        book2.setCategory(Category.NOVEL);
        book2.setAvailableCopies(70);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> save(BookDto book) {
        Author author = authorRepository.findById(book.getAuthor()).get();
        Book newBook = new Book();
        newBook.setName(book.getName());
        newBook.setAuthor(author);
        newBook.setCategory(book.getCategory());
        newBook.setAvailableCopies(book.getAvailableCopies());
        return Optional.of(this.bookRepository.save(newBook));
    }

}
