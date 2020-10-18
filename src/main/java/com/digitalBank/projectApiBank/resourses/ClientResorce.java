package com.digitalBank.projectApiBank.resourses;

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
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.services.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientResorce {

	@Autowired
	private ClientService clientService;

	@GetMapping(path = "/")
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = clientService.returnAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client clientObj = clientService.findById(id);
		return ResponseEntity.ok().body(clientObj);
	}

//	@PostMapping(path = "/save")
//	public ResponseEntity<Client> create(@Valid @RequestBody Client client) throws ConstraintViolationException {
//		return ResponseEntity.status(HttpStatus.CREATED).body(null);
//	}

	@PostMapping(path = "/save")
	public ResponseEntity<Object> saveClient(@RequestBody Client client) {

		Client response = clientService.saveClient(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}

//	
//	@DeleteMapping(path = "/delete/{id}")
//	public void deleteClient(
//			@PathVariable(name = "id",required = true) Long id) {
//		clientRepository.deleteById(id);
//	}


