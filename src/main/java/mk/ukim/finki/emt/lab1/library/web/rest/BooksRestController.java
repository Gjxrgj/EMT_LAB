package mk.ukim.finki.emt.lab1.library.web.rest;

import mk.ukim.finki.emt.lab1.library.models.Book;
import mk.ukim.finki.emt.lab1.library.service.AuthorService;
import mk.ukim.finki.emt.lab1.library.models.dto.BookDto;
import mk.ukim.finki.emt.lab1.library.service.BookService;
import mk.ukim.finki.emt.lab1.library.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BooksRestController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public BooksRestController(BookService bookService, AuthorService authorService, CountryService countryService) {

        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
        countryService.addCountries();
        authorService.addAuthors();
        bookService.addBooks();

    }

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/mark/{id}")
    public void markBook(@PathVariable Long id){
        bookService.markBook(id);
    }
    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto book){
        return this.bookService.save(book)
                .map(book1 -> ResponseEntity.ok().body(book1))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto book){
        return this.bookService.edit(id, book)
                .map(book1 -> ResponseEntity.ok().body(book1))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
