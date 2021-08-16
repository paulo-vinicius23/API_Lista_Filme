package com.APITeste.API.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APITeste.API.Repository.UsuarioRepository;
import com.APITeste.API.models.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuario;
	
	public Optional<Usuario> findById(Integer Id){
		return usuario.findById(Id);
	}
	
	public List<Usuario> findAll(){
		return usuario.findAll();
	}
	
	public Usuario saveUsuario(Usuario usu){
		return usuario.save(usu);
	}
	
	public void deleteUsuario(Integer usu){
		usuario.deleteById(usu);
	}
}
