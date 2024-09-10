package io.github.fkbinho.vendas;

import io.github.fkbinho.vendas.domain.entity.Cliente;
import io.github.fkbinho.vendas.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init (@Autowired ClienteRepository clienteRepository){
		return args -> {
			clienteRepository.save(new Cliente("Kleber"));
			clienteRepository.save(new Cliente("Pedro"));

			List<Cliente> todosClientes = clienteRepository.findAll();
			todosClientes.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}