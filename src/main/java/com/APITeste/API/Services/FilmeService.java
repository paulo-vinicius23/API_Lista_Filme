package com.APITeste.API.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APITeste.API.Repository.FilmeRepository;
import com.APITeste.API.models.Categoria;
import com.APITeste.API.models.Filme;


@Service
public class FilmeService {
	
	@Autowired
	FilmeRepository filme;
	
	@Autowired
	CategoriaService categoria;
	
	public List<Filme> findByName(String fil){
		return filme.searchName(fil);
	}
	
	public List<Filme> findByCategoria(Long id){
		Optional<Categoria> cat = categoria.findById(id);
		List<Filme> fil = new ArrayList<Filme>();
		if (cat.isPresent()) {
			fil = filme.findByCategoria(cat.get());
			return fil;
		}
		return null;
	}
	
	public Optional<Filme> findById(Long id){
		return filme.findById(id);
	}
	
	public List<Filme> findAll(){
		return filme.findAll();
	}
	
	public Filme saveFilme(Filme fil){
		if (fil.categoria != null) {
			Optional<Categoria> cat = categoria.findById(fil.categoria.id);
			if (cat.isPresent()) {
				fil.categoria = cat.get();
			}
		}
		return filme.save(fil);
	}
	
	public void deleteFilme(Long id){
		filme.deleteById(id);
	}
}
