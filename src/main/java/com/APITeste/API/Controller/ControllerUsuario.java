package com.APITeste.API.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> getUsuario(@PathVariable(value= "id") Long id){
		try {
		 	Optional<Usuario> usu = usuario.findById(id);
		 	if (usu.isPresent()) {
		 		return new ResponseEntity<Optional<Usuario>>(usu, HttpStatus.OK);
			}
			return new ResponseEntity<String>("Usuario Não Existente", HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			return new ResponseEntity<String>("Usuario Invalido", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/todos-usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getAllUsuarios(){
		try {
			List<Usuario> usu = usuario.findAll();
			return new ResponseEntity<List<Usuario>>(usu, HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<String>("Erro Desconhecido", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/salvar-usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> saveUsuario(@RequestBody Usuario usu){
		try {
			Usuario usua = usuario.saveUsuario(usu);
			return new ResponseEntity<Usuario>(usua, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("Erro Desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/delete-usuario/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteUsuarioById(@PathVariable(value= "id") Long id) {
		try {
			usuario.deleteUsuario(id);
			return new ResponseEntity<String>("Categoria de id " + id + " deletada.", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("Erro Desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
