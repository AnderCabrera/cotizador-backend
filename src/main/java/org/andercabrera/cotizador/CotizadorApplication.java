package org.andercabrera.cotizador;

import java.util.List;

import org.andercabrera.cotizador.model.User;
import org.andercabrera.cotizador.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CotizadorApplication {
	public static void main(String[] args) {
		SpringApplication.run(CotizadorApplication.class, args);
	}
}
