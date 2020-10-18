package com.digitalBank.projectApiBank.services;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.repositories.AddressRepository;
import com.digitalBank.projectApiBank.repositories.ClientRepository;
import com.digitalBank.projectApiBank.services.exceptions.ConstraintViolationException;
import com.digitalBank.projectApiBank.services.exceptions.EntityNotFoundException;
import com.google.common.base.Optional;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	

	public Optional<Address> returnAll() {
		Optional<Address> address = (Optional<Address>) addressRepository.findAll();
		return address;
	}

	public Address saveAddress(@RequestBody Address address) {
		return addressRepository.save(address);

	}

}
