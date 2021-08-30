package com.APITeste.API.Config.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.APITeste.API.Repository.UsuarioRepository;
import com.APITeste.API.models.Usuario;

@Service
public class AutentcService implements UserDetailsService{
	
	@Autowired
	public UsuarioRepository usuario;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usu = usuario.findByEmail(username);
		if (usu.isPresent()){
			return usu.get();
		}
		throw new UsernameNotFoundException("Email ou Senha Inválido");
	}

}
