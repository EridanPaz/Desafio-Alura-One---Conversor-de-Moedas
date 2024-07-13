package com.alura.conversor_de_moeda;

import com.alura.conversor_de_moeda.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorDeMoedaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConversorDeMoedaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.menu();
	}
}
