package com.digitalBank.projectApiBank.resourses;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.services.AddressService;
import com.digitalBank.projectApiBank.services.ClientService;


@RestController
@RequestMapping("client/save/address/confirmation")
public class ConfirmationResorce {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AddressService addressService;
	

	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Client clientObj = clientService.findById(id);
		Address addressId = addressService.findById(id);
		
		List<Object> objComfirmation = new ArrayList<>();
		
		objComfirmation.add(clientObj);
		objComfirmation.add(addressId);
		return ResponseEntity.ok().body(objComfirmation);
	}


	

}
