package com.APITeste.API.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.APITeste.API.Services.AutorService;
import com.APITeste.API.models.Autor;

@RestController
@RequestMapping("/")
public class ControllerAutor {
	@Autowired
	AutorService autor;
	
	@RequestMapping("/autor/{id}")
	@ResponseBody
	public Optional<Autor> getFilme(@RequestParam Integer id){
		return autor.findById(id);
	}
	
	@GetMapping(value = "/todos-autores", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Autor> getAllFilme(){
		return autor.findAll();
	}
	
	@PostMapping(value = "/salvar-autor/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Autor saveFilme(@RequestBody Autor aut){
		return autor.saveAutor(aut);
	}
	
	@GetMapping(value = "/delete-autor/{id}")
	@ResponseBody
	public String deleteAutorById(@RequestParam Integer id) {
		autor.deleteAutor(id);
		return "Autor de id " + id + " deletado.";
	}
}
