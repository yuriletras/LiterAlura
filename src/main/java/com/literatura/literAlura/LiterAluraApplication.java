package com.literatura.literAlura;

import com.literatura.literAlura.principal.Principal; // Importe sua classe Principal
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Anotação que marca a classe principal da aplicação Spring Boot
// CommandLineRunner: Uma interface do Spring Boot que permite executar código
// assim que a aplicação é iniciada e as dependências são carregadas.
public class LiterAluraApplication implements CommandLineRunner {

	// @Autowired: O Spring automaticamente encontra e injeta uma instância da sua classe Principal aqui.
	@Autowired
	private Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args); // Inicia a aplicação Spring Boot
	}

	// Este método é executado assim que a aplicação Spring Boot é carregada.
	@Override
	public void run(String... args) throws Exception {
		principal.exibirMenu(); // Chama o método exibirMenu da sua classe Principal
	}
}