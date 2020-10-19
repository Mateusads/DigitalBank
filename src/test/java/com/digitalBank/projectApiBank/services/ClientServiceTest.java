package com.digitalBank.projectApiBank.services;

import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.digitalBank.projectApiBank.Impl.ClientServiceImpl;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.repositories.ClientRepository;
import com.digitalBank.projectApiBank.services.ClientService;

@SpringBootTest
public class ClientServiceTest {
	
	@MockBean
	private ClientRepository clientRepository;	
	
	private ClientService clientService;
	
	private Client client;
	
	private static final String NOME = "Mateus";
	private static final String SOBRENOME = "Medeiros";
	private static final String CPF = "452.452.452-75";
	private static final String EMAIL = "mateus@mateus.com";
	private static final LocalDate DATANASCIMENTO = LocalDate.parse("2000-10-10");
	
	@BeforeEach
	public void setUp() throws Exception{
		
		clientService = new ClientServiceImpl(clientRepository);
		client = new Client();
		client.setNome(NOME);
		client.setSobrenome(SOBRENOME);		
		client.setCpf(CPF);
		client.setEmail(EMAIL);
		client.setDataNascimento(DATANASCIMENTO);
		
	}
	
	
	@Test
	public void save_client_repository() throws Exception{
		
		clientService.saveClient(client);
		
		verify(clientRepository).save(client);
		
	}

}
