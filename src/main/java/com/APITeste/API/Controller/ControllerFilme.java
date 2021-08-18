package com.APITeste.API.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.APITeste.API.Services.FilmeService;
import com.APITeste.API.models.Filme;

@RestController
@RequestMapping("/")
public class ControllerFilme {
	@Autowired
	FilmeService filme;
	
	@GetMapping("/filme/{fil}")
	@ResponseBody
	public List<Filme> getFilme(@PathVariable(value= "fil") String fil){
		return filme.findByName(fil);
	}
	
	@GetMapping(value = "/todos-filmes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Filme> getAllFilme(){
		return filme.findAll();
	}
	
	@PostMapping(value = "/salvar-filme/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Filme saveFilme(@RequestBody Filme fil){
		return filme.saveFilme(fil);
	}
	
	@GetMapping(value = "/delete-filme/{id}")
	@ResponseBody
	public String deleteFilmeById(@PathVariable(value= "id") Integer id) {
		filme.deleteFilme(id);
		return "Categoria de id " + id + " deletada.";
	}
}