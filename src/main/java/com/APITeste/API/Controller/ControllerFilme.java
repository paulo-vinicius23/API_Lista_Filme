package com.APITeste.API.Controller;

import java.util.List;
import java.util.Optional;
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
import com.APITeste.API.Services.DiretorService;
import com.APITeste.API.Services.FilmeService;
import com.APITeste.API.models.Diretor;
import com.APITeste.API.models.Filme;

@RestController
@RequestMapping("/")
public class ControllerFilme {
	
	@Autowired
	DiretorService diretor;
	
	@Autowired
	FilmeService filme;
	
	@RequestMapping("/filme-id/{id}")
	@ResponseBody
	public Optional<Filme> getFilmeById(@PathVariable(value= "id") Long id){
		return filme.findById(id);
	}
	
	@GetMapping("/filme-nome/{fil}")
	@ResponseBody
	public List<Filme> getFilme(@PathVariable(value= "fil") String fil){
		return filme.findByName(fil);
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
	public List<Filme> getAllFilme(){
		return filme.findAll();
	}
	
	@PostMapping(value = "/salvar-filme", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Filme saveFilme(@RequestBody Filme fil){
		return filme.saveFilme(fil);
	}
	
	@GetMapping(value = "/delete-filme/{id}")
	@ResponseBody
	public String deleteFilmeById(@PathVariable(value= "id") Long id) {
		filme.deleteFilme(id);
		return "Filme de id " + id + " deletado.";
	}
	
	@PostMapping(value = "/salvar-diretor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Diretor saveDiretor(@RequestBody Diretor dir){
		return diretor.saveDiretor(dir);
	}
}