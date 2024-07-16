package com.alura.literalura;

import com.alura.literalura.principal.Principal;
import com.alura.literalura.repository.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.literalura.repository.LibroRepositorio;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner{

	@Autowired
	private LibroRepositorio repository;

	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);
	}
	@Autowired
	private AutorRepositorio autorRepositorio;
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository, autorRepositorio);
		principal.muestraElMenu();
	}
}


