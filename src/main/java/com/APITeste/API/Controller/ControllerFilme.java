package com.APITeste.API.Controller;

import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.APITeste.API.Services.AutorService;
import com.APITeste.API.Services.FilmeService;
import com.APITeste.API.models.Filme;

@RestController
@RequestMapping("/")
public class ControllerFilme {
	@Autowired
	FilmeService filme;
	
	@PostMapping(value = "/filme", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Optional<Filme> getFilme(@RequestParam Integer id){
		return filme.findById(id);
	}
	
	@PostMapping(value = "/todos-filmes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Iterable<Filme> getAllFilme(){
		return filme.findAll();
	}
	
	@PostMapping(value = "/salvar-filme", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Filme saveFilme(Filme fil){
		return filme.saveFilme(fil);
	}
}
