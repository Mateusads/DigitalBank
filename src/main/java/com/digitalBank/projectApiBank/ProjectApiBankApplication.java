package com.digitalBank.projectApiBank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.repositories.AddressRepository;
import com.digitalBank.projectApiBank.repositories.ClientRepository;

@SpringBootApplication
public class ProjectApiBankApplication implements CommandLineRunner{
	  

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectApiBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		;
		LocalDate dataNascimento = LocalDate.parse("2000-10-10");
		Client client1 = new Client("Mateus", "Medeiros", "mateus@mateus.com", "090.828.700-70", dataNascimento);
		
//		Address ad1 = new Address("89460-000", "de Deus", "Jardim", "casa", "Canoinhas", "SC");
//		
//		Address ad2 = new Address("89460-000", "de Deus", "Jardim", "casa", "Canoinhas", "SC");
//		
//		client1.getAddress().addAll(Arrays.asList(ad1, ad2));
//		
		clientRepository.save(client1);
//		
//		addressRepository.save(ad1);


	}

}
