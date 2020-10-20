package com.digitalBank.projectApiBank.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


	private static String JWTSECRET = "SAODKASODKASAOSKDOAS";

//	@Value("${app.jwtExpirationInMs}")
//	private int jwtExpirationInMs;

	public String generateToken(Client client) {

		return Jwts.builder()
				.setSubject(client.getNome())
				.signWith(SignatureAlgorithm.HS512, JWTSECRET).compact();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(JWTSECRET).parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			throw new ConstraintViolationException("error information = /n" + e);
		}
	}

}