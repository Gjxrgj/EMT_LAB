package mk.ukim.finki.emt.lab1.library.repository;

import mk.ukim.finki.emt.lab1.library.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
