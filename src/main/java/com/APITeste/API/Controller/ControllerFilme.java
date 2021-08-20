package com.APITeste.API.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.APITeste.API.Services.DiretorService;
import com.APITeste.API.Services.FilmeService;
import com.APITeste.API.models.Diretor;
import com.APITeste.API.models.Filme;

@RestController
@RequestMapping("/")
public class ControllerFilme {
	@Autowired
	FilmeService filme;
	
	@Autowired
	DiretorService diretor;
	
	@GetMapping("/filme/{fil}")
	@ResponseBody
	public List<Filme> getFilme(@PathVariable(value= "fil") String fil){
		return filme.findByName(fil);
	}
	
	@GetMapping("/filme-categoria/{id}")
	@ResponseBody
	public List<Filme> getFilmeByCategoria(@PathVariable(value= "id") Integer id){
		List<Filme> fil = filme.findByCategoria(id);
		return fil;
	}
	
	@GetMapping(value = "/todos-filmes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Filme> getAllFilme(){
		return filme.findAll();
	}
	
	@PostMapping(value = "/salvar-filme", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Filme saveFilme(@RequestBody Filme fil){
		return filme.saveFilme(fil);
	}
	
	@PostMapping(value = "/salvar-diretor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Diretor saveDiretor(@RequestBody Diretor dir){
		return diretor.saveDiretor(dir);
	}
	
	@GetMapping(value = "/delete-filme/{id}")
	@ResponseBody
	public String deleteFilmeById(@PathVariable(value= "id") Integer id) {
		filme.deleteFilme(id);
		return "Filme de id " + id + " deletado.";
	}
	
	@GetMapping(value = "/delete-diretor/{id}")
	@ResponseBody
	public String deleteDiretorById(@PathVariable(value= "id") Integer id){
		diretor.deleteDiretor(id);
		return "Autor de id " + id + " deletado.";
	}
}