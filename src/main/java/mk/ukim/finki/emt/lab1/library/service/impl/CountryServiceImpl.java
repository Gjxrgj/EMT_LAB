package mk.ukim.finki.emt.lab1.library.service.impl;

import mk.ukim.finki.emt.lab1.library.models.Country;
import mk.ukim.finki.emt.lab1.library.repository.CountryRepository;
import mk.ukim.finki.emt.lab1.library.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void addCountries() {
        Country country1 = new Country();
        country1.setName("Russia");
        country1.setContinent("Asia");
        country1.setId(1L);
        Country country2 = new Country();
        country2.setName("Europe");
        country2.setContinent("Serbia");
        country2.setId(2L);
        countryRepository.save(country1);
        countryRepository.save(country2);
    }
}
