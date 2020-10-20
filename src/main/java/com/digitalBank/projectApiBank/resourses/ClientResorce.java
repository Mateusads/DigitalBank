package com.digitalBank.projectApiBank.resourses;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.digitalBank.projectApiBank.Security.JwtCreateToken;
import com.digitalBank.projectApiBank.Security.TokenAuthenticationService;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.services.ClientService;

@RestController
@EnableAutoConfiguration
@PreAuthorize("permitAll()")
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

	@PostMapping(path = "/save")
	public ResponseEntity<Object> saveClient(@RequestBody Client client) throws IOException, ServletException {
		Client response = clientService.saveClient(client);
		JwtCreateToken jwtCreateToken = new JwtCreateToken();
		String token = jwtCreateToken.generateTokenClient(response, "jwtscretclient");
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/address/{id}")
                .buildAndExpand(response.getIdClient())
                .toUri();
        return ResponseEntity.created(location)
        		.header("Token_Client ", token)
        		.body(response);

	}
}
//	
//	@DeleteMapping(path = "/delete/{id}")
//	public void deleteClient(
//			@PathVariable(name = "id",required = true) Long id) {
//		clientRepository.deleteById(id);
//	}
