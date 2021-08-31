package com.APITeste.API.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.APITeste.API.Services.UsuarioService;
import com.APITeste.API.models.Usuario;

@RestController
@RequestMapping("/")
public class ControllerUsuario {
	
	UsuarioService usuario;
	
	@RequestMapping("/usuario/{id}")
	@ResponseBody
	public Optional<Usuario> getUsuario(@PathVariable(value= "id") Long id){
		return usuario.findById(id);
	}
	
	@GetMapping(value = "/todos-usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Usuario> getAllUsuarios(){
		return usuario.findAll();
	}
	
	@PostMapping(value = "/salvar-usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Usuario saveUsuario(@RequestBody Usuario usu){
		return usuario.saveUsuario(usu);
	}
	
	@GetMapping(value = "/delete-usuario/{id}")
	@ResponseBody
	public String deleteUsuarioById(@PathVariable(value= "id") Long id) {
		usuario.deleteUsuario(id);
		return "Categoria de id " + id + " deletada.";
	}
}
