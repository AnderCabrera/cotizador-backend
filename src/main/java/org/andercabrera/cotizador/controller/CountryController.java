package org.andercabrera.cotizador.controller;

import java.util.List;

import org.andercabrera.cotizador.model.Country;
import org.andercabrera.cotizador.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

  @Autowired
  private CountryService countryService;

  @GetMapping(value = "/", produces = "application/json")
  public List<Country> getCountries() {
    return countryService.list();
  }

  @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
  public Country save(@RequestBody Country country) {
    return countryService.save(country);
  }
}
