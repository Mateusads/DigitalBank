package com.digitalBank.projectApiBank.resourses;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.repositories.AddressRepository;
import com.digitalBank.projectApiBank.repositories.ClientRepository;
import com.digitalBank.projectApiBank.services.AddressService;
import com.digitalBank.projectApiBank.services.ClientService;
import com.digitalBank.projectApiBank.services.AddressService;

@RestController
@RequestMapping(value = "client/save/address/")
public class AddressResorce {
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ClientService clientService;
	
//	@GetMapping(path = "/")
//	public ResponseEntity<List<Address>> findAll() {
//		List<Address> list = addressService.returnAll();
//		return ResponseEntity.ok().body(list);
//	}

	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id) {
		
		Client cli1 = clientService.findById(id);
		Address addresstObj = addressService.findById(id);
		addresstObj.getClient();
		return ResponseEntity.ok().body(addresstObj);
	}
	
	@PostMapping(path = "/{id}" )
	public ResponseEntity<Address> saveAddress(@RequestBody Address address, @PathVariable Long id) {
		Client cli1 = clientService.findById(id);
		address.getClient().addAll(Arrays.asList(cli1));
		Address response = addressService.saveAddress(address);
	       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/img/")
	                .buildAndExpand(cli1.getIdClient())
	                .toUri();
	        return ResponseEntity.created(location).body(response);
	}

}
