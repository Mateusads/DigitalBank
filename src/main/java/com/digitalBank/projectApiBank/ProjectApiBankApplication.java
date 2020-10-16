package com.digitalBank.projectApiBank;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.repositories.ClientRepository;

@SpringBootApplication
public class ProjectApiBankApplication implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectApiBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Long cpf = (long) 1212343;
		Client client1 = new Client("Mateus", "Medeiros", "mateus@medeiros", cpf);

		
		clientRepository.save(client1);

		
	}

}
