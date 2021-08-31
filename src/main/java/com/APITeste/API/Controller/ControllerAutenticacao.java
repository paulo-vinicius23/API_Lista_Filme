package com.APITeste.API.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.APITeste.API.Config.Security.TokenService;
import com.APITeste.API.Controller.dto.TokenDto;
import com.APITeste.API.Controller.form.LoginForm;

@RestController
@RequestMapping("/")
public class ControllerAutenticacao {
	
	@Autowired
	private AuthenticationManager auten;
	
	@Autowired
	private TokenService token;
	
	@PostMapping(value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken user = form.converter();
		try{
			Authentication autenII = auten.authenticate(user);
			String tok = token.criarToken(autenII);
			return ResponseEntity.ok(new TokenDto(tok, "Bearer"));
		}catch(AuthenticationException erro){
			return ResponseEntity.badRequest().build();
		}
	}
}
