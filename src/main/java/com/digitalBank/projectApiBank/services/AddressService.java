package com.digitalBank.projectApiBank.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.repositories.AddressRepository;
import com.digitalBank.projectApiBank.repositories.ClientRepository;
import com.digitalBank.projectApiBank.repositories.AddressRepository;
import com.digitalBank.projectApiBank.services.exceptions.ConstraintViolationException;
import com.digitalBank.projectApiBank.services.exceptions.EntityNotFoundException;
import com.google.common.base.Optional;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;



	public List<Address> returnAll() {
		List<Address> list = addressRepository.findAll();
		return list;
	}
	
	public Address findById(Long id) {
		return addressRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("id Address " + id + " not found"));
	}

	public Address saveAddress(@Valid @RequestBody Address address) {
		try {
			return addressRepository.save(address);
		} catch (Exception e) {
			throw new ConstraintViolationException("error information = /n" + e);
		}


	}

}
