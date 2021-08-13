package com.APITeste.API.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.APITeste.API.Services.AutorService;
import com.APITeste.API.Services.FilmeService;
import com.APITeste.API.models.Filme;

@RestController
@RequestMapping("/")
public class Controller {
	@Autowired
	FilmeService filme;
	@Autowired
	AutorService autor;
	
	@RequestMapping("/filme")
	@ResponseBody
	public Optional<Filme> getFilme(@RequestParam Integer id){
		return filme.findById(id);
	}
	
	@RequestMapping("/todos-filmes")
	@ResponseBody
	public Iterable<Filme> getAllFilme(){
		return filme.findAll();
	}
}
