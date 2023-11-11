package org.andercabrera.cotizador;

import java.util.List;

import org.andercabrera.cotizador.model.Country;
import org.andercabrera.cotizador.model.Package;
import org.andercabrera.cotizador.model.User;
import org.andercabrera.cotizador.repositories.CountryRepository;
import org.andercabrera.cotizador.repositories.PackageRepository;
import org.andercabrera.cotizador.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// @RestController
public class CotizadorApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PackageRepository packageRepository; 

	@Autowired
	private CountryRepository countryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CotizadorApplication.class, args);
	}

	@GetMapping("/api/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("api/packages")
	public List<Package> getPackages() {
		return packageRepository.findAll();
	}
	
	@GetMapping("api/countries")
	public List<Country> getCountries() {
		return countryRepository.findAll();
	}
}
