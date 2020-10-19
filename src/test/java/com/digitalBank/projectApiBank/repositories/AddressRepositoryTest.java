package com.digitalBank.projectApiBank.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.digitalBank.projectApiBank.entities.Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressRepositoryTest {
	
	@Autowired
	private AddressRepository addressRepository;
	

	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void createAddressData() {
		Address address = new Address("89460-000", "de Deus", "Jardim", "casa", "Canoinhas", "SC");
		this.addressRepository.save(address);
		assertThat(address.getIdAdress()).isNotNull();
		assertThat(address.getCep()).isEqualTo("89460-000");
		assertThat(address.getBairro()).isEqualTo("Jardim");
		assertThat(address.getRua()).isEqualTo("de Deus");
		assertThat(address.getComplemento()).isEqualTo("casa");
		assertThat(address.getCidade()).isEqualTo("Canoinhas");
		assertThat(address.getEstado()).isEqualTo("SC");
	}
}
