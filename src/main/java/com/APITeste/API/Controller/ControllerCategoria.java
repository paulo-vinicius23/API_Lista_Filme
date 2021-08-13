package com.APITeste.API.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.APITeste.API.Services.CategoriaService;
import com.APITeste.API.models.Categoria;

@RestController
@RequestMapping("/")
public class ControllerCategoria {

		@Autowired
		CategoriaService categoria;
		
		@PostMapping(value = "/categoria", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public Optional<Categoria> getCategoria(@RequestParam Integer id){
			return categoria.findById(id);
		}
		
		@PostMapping(value = "/todas-categorias", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public Iterable<Categoria> getAllCategoria(){
			return categoria.findAll();
		}
		
		@PostMapping(value = "/salvar-categoria", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public Categoria saveCategoria(@RequestBody Categoria cat){
			return categoria.saveCategoria(cat);
		}
}