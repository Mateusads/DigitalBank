package com.digitalBank.projectApiBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.repositories.ClientRepository;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = clientRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(path = "/{cpf}")
	public ResponseEntity<Client> findByCPF(@PathVariable Long cpf) {
		Client cliente = clientRepository.findById(cpf).get();
		return ResponseEntity.ok().body(cliente);
	}
	
	@PostMapping(path = "/client/save")
	public void saveClient(@RequestBody Client client) {
		clientRepository.save(client);
	}
	
	@DeleteMapping(path = "/client/delete/{cpf}")
	public void deleteClient(
			@PathVariable(name = "cpf",required = true) Long cpf) {
		clientRepository.deleteById(cpf);
	}
	

}