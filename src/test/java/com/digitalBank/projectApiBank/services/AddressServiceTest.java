package com.digitalBank.projectApiBank.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.digitalBank.projectApiBank.Impl.AddressServiceImpl;
import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.repositories.AddressRepository;

@SpringBootTest
class AddressServiceTest {

	@MockBean
	private AddressRepository addressRepository;	
	
	private AddressService addressService;
	
	private Address address;

	
	private static final String CEP = "89460-000";
	private static final String RUA = "AV Isabel";
	private static final String BAIRRO = "Jardim";
	private static final String COMPLEMENTO = "casa";
	private static final String CIDADE = "Canoinhas";
	private static final String ESTADO = "SC";
	
	@BeforeEach
	public void setUp() throws Exception{
		
		addressService = new AddressServiceImpl(addressRepository);
		address = new Address();
		address.setCep(CEP);
		address.setRua(RUA);
		address.setBairro(BAIRRO);
		address.setComplemento(COMPLEMENTO);
		address.setCidade(CIDADE);
		address.setEstado(ESTADO);
	}
	
	
	@Test
	public void save_address_repository() throws Exception{
		
		addressService.saveAddress(address);
		
		verify(addressRepository).save(address);
		
	}

}
