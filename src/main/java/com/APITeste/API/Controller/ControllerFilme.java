package com.APITeste.API.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.APITeste.API.Services.FilmeService;
import com.APITeste.API.models.Filme;

@RestController
@RequestMapping("/")
public class ControllerFilme {
	
	@Autowired
	FilmeService filme;
	
	@RequestMapping("/filme-id/{id}")
	@ResponseBody
	public ResponseEntity<?> getFilmeById(@PathVariable(value= "id") Long id){
		try {
			Optional<Filme> fil = filme.findById(id);
			if (fil.isPresent()) {
				return new ResponseEntity<Optional<Filme>>(fil, HttpStatus.OK);
			}
			return new ResponseEntity<String>("Filme Não Encontrado", HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			return new ResponseEntity<String>("Filme Inválido", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/filme-nome/{fil}")
	@ResponseBody
	public ResponseEntity<?> getFilme(@PathVariable(value= "fil") String fil){
		try {
			List<Filme> film = filme.findByName(fil);
			return new ResponseEntity<List<Filme>>(film, HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<String>("Filme inválido", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/filme-categoria/{id}")
	@ResponseBody
	public ResponseEntity<?> getFilmeByCategoria(@PathVariable(value= "id") Long id){
		try {
			List<Filme> fil = filme.findByCategoria(id);
			if (fil == null) {
				return new ResponseEntity<String>("Categoria Não Encontrada", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Filme>>(fil, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("Categoria Inválida", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/todos-filmes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getAllFilme(){
		try {
			List<Filme> film = filme.findAll();
			return new ResponseEntity<List<Filme>>(film, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("Erro Desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/salvar-filme", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> saveFilme(@RequestBody @Valid Filme fil){
		try {
			Filme film = filme.saveFilme(fil);
			return new ResponseEntity<Filme>(film, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("Erro Desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/delete-filme/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteFilmeById(@PathVariable(value= "id") Long id) {
		try {
			filme.deleteFilme(id);
			return new ResponseEntity<String>("Filme de id " + id + " deletado.", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("Erro Desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}