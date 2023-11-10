package org.andercabrera.cotizador.repositories;

import org.andercabrera.cotizador.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
  
}
