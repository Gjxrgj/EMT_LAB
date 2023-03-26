package mk.ukim.finki.emt.lab1.library.service;

import mk.ukim.finki.emt.lab1.library.models.Author;

import java.util.List;

public interface AuthorService {
    void addAuthors();
    List<Author> getAuthors();
}
