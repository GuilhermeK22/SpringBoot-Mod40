package br.com.guilhermekpp.SpringBootPrimeiroExemplo;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.guilhermekpp.domain.Cliente;
import br.com.guilhermekpp.repository.IClienteRepository;


@Configuration
@EnableJpaRepositories(basePackages = "br.com.guilhermekpp.repository")
@EntityScan("br.com.guilhermekpp.*")  
@ComponentScan(basePackages = "br.com.guilhermekpp")
@SpringBootApplication


public class SpringBootPrimeiroExemploApplication implements CommandLineRunner {

	private static final Logger log = (Logger) LoggerFactory.getLogger(SpringBootPrimeiroExemploApplication.class);
	
	@Autowired
	private IClienteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPrimeiroExemploApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		log.info("StartApllication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}
	
	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("SP")
				.cpf(12312312310L)
				.email("Teste@teste.com")
				.end("End")
				.estado("SP")
				.nome("Teste Spring Boot")
				.numero(102030)
				.tel(10203040L)
				.build();
	}

}
