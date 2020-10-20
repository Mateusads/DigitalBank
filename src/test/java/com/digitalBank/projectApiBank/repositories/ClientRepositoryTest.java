package com.digitalBank.projectApiBank.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.digitalBank.projectApiBank.entities.Client;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class ClientRepositoryTest {
		
		@Autowired
		private ClientRepository clientRepository;
		

		
		@Rule
		public ExpectedException thrown = ExpectedException.none();
		
		@Test
		public void createClientData() {
			Client client = new Client("Mateus", "Medeiros", "mateus@medeiros.com", "789.789.789-78", LocalDate.parse("2000-10-10"));
			this.clientRepository.save(client);
			assertThat(client.getIdClient()).isNotNull();
			assertThat(client.getNome()).isEqualTo("Mateus");
			assertThat(client.getSobrenome()).isEqualTo("Medeiros");
			assertThat(client.getEmail()).isEqualTo("mateus@medeiros.com");
			assertThat(client.getCpf()).isEqualTo("789.789.789-78");
			assertThat(client.getDataNascimento()).isEqualTo("2000-10-09");
		}
	}