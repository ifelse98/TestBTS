package com.bts.test.Security;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.bts.test.Service.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${com.app.jwtSecret}")
	private String jwtSecret;

	@Value("${com.app.jwtExpiration}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder().setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public String getUserNameFromJwt(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException err) {
			logger.error("Invalid Jwt signature : {}", err.getMessage());
		} catch (MalformedJwtException err) {
			logger.error("Invalid Jwt Token : {}", err.getMessage());
		} catch (ExpiredJwtException err) {
			logger.error("JWT token is expired : {}", err.getMessage());
		} catch (UnsupportedJwtException err) {
			logger.error("JWT token is unsupported : {}", err.getMessage());
		} catch (IllegalArgumentException err) {
			logger.error("JWT claims string is empty : {}", err.getMessage());
		}
		return false;
	}
}