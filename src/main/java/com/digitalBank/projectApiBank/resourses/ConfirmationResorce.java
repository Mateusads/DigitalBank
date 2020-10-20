package com.digitalBank.projectApiBank.resourses;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.HashMap;
import java.util.List;
import java.util.Map;

>>>>>>> main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD
import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.services.AddressService;
import com.digitalBank.projectApiBank.services.ClientService;


@RestController
@RequestMapping("client/save/address/confirmation")
=======

import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.entities.ImgCPF;
import com.digitalBank.projectApiBank.services.AddressService;
import com.digitalBank.projectApiBank.services.ClientService;
import com.digitalBank.projectApiBank.services.ImgCPFService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/fotos")
>>>>>>> main
public class ConfirmationResorce {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AddressService addressService;
	
<<<<<<< HEAD

=======
	@Autowired
	private ImgCPFService imgCPFService;
	
>>>>>>> main
	
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
