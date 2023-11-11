package org.andercabrera.cotizador.services;

import java.util.List;
import java.util.Optional;

import org.andercabrera.cotizador.model.Country;
import org.andercabrera.cotizador.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CountryService {

  @Autowired
  private CountryRepository countryRepository;

  /**
   * @return country from database
   */

  public List<Country> list() {
    return countryRepository.findAll();
  }

  /**
   * Create a new country Object and save it in database
   * @param country
   * @return success message
   */

  public Country save(Country country) {
    return countryRepository.save(country);
  }

  /**
   * Search for a country in <strong>database</strong> throught id
   * @param id 
   * @return Country Object
   */

  public Country get(int id) {
    Optional<Country> countryOptional = countryRepository.findById(id);

    if (countryOptional.isEmpty()) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND
      );
    }

    return countryOptional.get();
  }
}
