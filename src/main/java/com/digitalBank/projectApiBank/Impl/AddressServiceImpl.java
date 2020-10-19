package com.digitalBank.projectApiBank.Impl;

import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.repositories.AddressRepository;
import com.digitalBank.projectApiBank.services.AddressService;

public class AddressServiceImpl extends AddressService {
	
	private final AddressRepository addressRepository;

	public AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

}
