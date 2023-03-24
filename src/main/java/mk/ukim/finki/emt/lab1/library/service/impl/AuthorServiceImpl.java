package mk.ukim.finki.emt.lab1.library.service.impl;

import mk.ukim.finki.emt.lab1.library.models.Author;
import mk.ukim.finki.emt.lab1.library.repository.AuthorRepository;
import mk.ukim.finki.emt.lab1.library.repository.CountryRepository;
import mk.ukim.finki.emt.lab1.library.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void addAuthors() {
        Author author1 = new Author();
        author1.setName("Leo");
        author1.setSurname("Tolstoy");
        author1.setId(1L);
        author1.setCountry(countryRepository.getById(1L));
        Author author2 = new Author();
        author2.setName("Borislav");
        author2.setSurname("Pekic");
        author2.setId(2L);
        author2.setCountry(countryRepository.getById(2L));
        authorRepository.save(author1);
        authorRepository.save(author2);
    }
}
