package com.digitalBank.projectApiBank.resourses;

import java.net.URI;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.digitalBank.projectApiBank.Security.JwtCreateToken;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.entities.ImgCPF;
import com.digitalBank.projectApiBank.services.ClientService;
import com.digitalBank.projectApiBank.services.ImgCPFService;

@RestController
@RequestMapping("client/save/address/")
public class UploadCPFResource {
	
	@Autowired
	private ImgCPFService imgCPFService;
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping (path = "/{id}/img")
	public ResponseEntity<ImgCPF> upload(@RequestParam MultipartFile photoCPF, String token, Long id) {		
		JwtCreateToken jwtCreateToken = new JwtCreateToken();
		Boolean tokenVerify = jwtCreateToken.validateToken(token, "jwtscretaddress");
		if(tokenVerify) {
			ImgCPF imgCPF = new ImgCPF(photoCPF.getOriginalFilename());
			imgCPFService.savePhoto(photoCPF);			
			Client cli1 = clientService.findById(id);
			imgCPF.getClient().addAll(Arrays.asList(cli1));
			ImgCPF response = imgCPFService.saveImgCPF(imgCPF);
		       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		                .path("/confirmation")
		                .buildAndExpand()
		                .toUri();
		        return ResponseEntity.created(location).body(response);
		}else {
			throw new IllegalArgumentException("error information = ");
		}		
		
	}

}
