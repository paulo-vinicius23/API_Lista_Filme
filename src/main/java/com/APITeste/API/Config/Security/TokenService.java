package com.APITeste.API.Config.Security;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.APITeste.API.models.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;

	public String criarToken(Authentication authen){
		Usuario login = (Usuario) authen.getPrincipal();
		Date hoje = new Date();
		Date dataExpiration = new Date(hoje.getTime() + Long.parseLong(expiration));
		return Jwts.builder().setIssuer("API Locadora").setSubject(login.getId().toString())
			.setExpiration(dataExpiration).signWith(SignatureAlgorithm.HS256, secret)
			.compact();
	}

	public boolean isTokenValido(String tok){
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(tok);
			return true;
		} catch(Exception e) {
			return false;			
		}
	}

	public Long getIdUsuario(String tok) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(tok).getBody();
		return Long.parseLong(claims.getSubject());
	}
}