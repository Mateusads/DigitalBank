package com.digitalBank.projectApiBank.services;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.repositories.ClientRepository;
import com.digitalBank.projectApiBank.services.exceptions.ConstraintViolationException;
import com.digitalBank.projectApiBank.services.exceptions.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> returnAll() {
		List<Client> list = clientRepository.findAll();
		return list;
	}

	public Client findById(Long id) {
		return clientRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("id client " + id + " not found"));
	}


	public Client saveClient(@Valid @RequestBody Client client) {
		try {
			
			Boolean ageTrue = ageClient(client);
			if (ageTrue == true) {
				return clientRepository.save(client);
			} else {
				throw new IllegalArgumentException("error information IllegalArgumentException");
			}
			
		} catch (Exception e) {
			throw new ConstraintViolationException("error information = /n" + e);
		}

	}

	public Boolean ageClient(Client client) {
		LocalDate dataNascimento = client.getDataNascimento();
		int age = client.getAgeClient(dataNascimento);
		if (age < 18) {
			return false;
		} else
			return true;
	}

}
