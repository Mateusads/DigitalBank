package com.digitalBank.projectApiBank.Impl;

import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.repositories.ClientRepository;
import com.digitalBank.projectApiBank.services.ClientService;

public class ClientServiceImpl extends ClientService {

	private final ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}
	



}
