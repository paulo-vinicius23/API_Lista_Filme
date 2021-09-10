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
import com.APITeste.API.Services.CategoriaService;
import com.APITeste.API.models.Categoria;

@RestController
@RequestMapping("/")
public class ControllerCategoria {

		@Autowired
		CategoriaService categoria;
		
		@RequestMapping("/categoria/{id}")
		@ResponseBody
		public ResponseEntity<?> getCategoria(@PathVariable(value= "id") Long id){
			try {
				Optional<Categoria> cat = categoria.findById(id);
				if (cat.isPresent()) {
					return new ResponseEntity<Optional<Categoria>>(cat, HttpStatus.OK);
				}
				return new ResponseEntity<String>("Categoria Não Existente", HttpStatus.NOT_FOUND);
			} catch(Exception ex) {
				return new ResponseEntity<String>("Categoria Invalida", HttpStatus.BAD_REQUEST);
			}
		}
		
		@GetMapping(value = "/todas-categorias", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<?> getAllCategoria(){
			try {
				List<Categoria> cat = categoria.findAll();
				return new ResponseEntity<List<Categoria>>(cat, HttpStatus.OK);
			} catch(Exception ex) {
				return new ResponseEntity<String>("Erro Desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PostMapping(value = "/salvar-categoria", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<?> saveCategoria(@RequestBody @Valid Categoria cat){
			try {
				Categoria cate = categoria.saveCategoria(cat);
				return new ResponseEntity<Categoria>(cate, HttpStatus.OK);
			} catch(Exception ex) {
				return new ResponseEntity<String>("Erro Desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping(value = "/delete-categoria/{id}")
		@ResponseBody
		public ResponseEntity<String> deleteCategoriaById(@PathVariable(value= "id") Long id){
			try {	
				categoria.deleteCategoria(id);
				return new ResponseEntity<String>("Categoria de id " + id + " deletada.", HttpStatus.OK);
			} catch(Exception ex) {
				return new ResponseEntity<String>("Erro Desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}