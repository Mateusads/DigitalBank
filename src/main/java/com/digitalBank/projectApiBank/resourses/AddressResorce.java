package com.digitalBank.projectApiBank.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.repositories.AddressRepository;
import com.digitalBank.projectApiBank.services.AddressService;
import com.digitalBank.projectApiBank.services.ClientService;

@RestController
@RequestMapping(value = "/client/adress")
public class AddressResorce {
	
	@Autowired
	private AddressService addressService;
	
	
	
	@PostMapping(path = "/save")
	public Address saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

}
