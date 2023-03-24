package mk.ukim.finki.emt.lab1.library.models.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.emt.lab1.library.models.Author;
import mk.ukim.finki.emt.lab1.library.models.Category;
@Data
public class BookDto {
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private int availableCopies;
    @ManyToOne
    private Author author;

    public BookDto() {
    }
}
