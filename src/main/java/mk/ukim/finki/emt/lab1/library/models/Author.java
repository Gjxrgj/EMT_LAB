package mk.ukim.finki.emt.lab1.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Author {
    @Id
    private Long Id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Author() {
    }
}