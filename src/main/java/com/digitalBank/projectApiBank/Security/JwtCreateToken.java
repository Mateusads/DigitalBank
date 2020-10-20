package com.digitalBank.projectApiBank.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.digitalBank.projectApiBank.entities.Address;
import com.digitalBank.projectApiBank.entities.Client;
import com.digitalBank.projectApiBank.services.exceptions.ConstraintViolationException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtCreateToken {


//	@Value("${app.jwtExpirationInMs}")
//	private int jwtExpirationInMs;

	public String generateTokenClient(Client client, String jwtScret) {

		return Jwts.builder()
				.setSubject(client.getNome())
				.signWith(SignatureAlgorithm.HS512, jwtScret).compact();
	}

	public boolean validateToken(String authToken, String jwtScret) {
		try {
			Jwts.parser().setSigningKey(jwtScret).parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			throw new ConstraintViolationException("error information = /n" + e);
		}
	}

	public String generateTokenAddress(Address address, String jwtScret) {

		return Jwts.builder()
				.setSubject(address.getRua())
				.signWith(SignatureAlgorithm.HS512, jwtScret).compact();
	}

}