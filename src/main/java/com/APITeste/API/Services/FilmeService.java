package com.APITeste.API.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APITeste.API.Repository.FilmeRepository;
import com.APITeste.API.models.Filme;


@Service
public class FilmeService {
	
	@Autowired
	FilmeRepository filme;
	
	public Optional<Filme> findById(Integer Id){
		return filme.findById(Id);
	}
	
	public List<Filme> findAll(){
		return filme.findAll();
	}
	
	public Filme saveFilme(Filme fil){
		return filme.save(fil);
	}
	
	public void deleteFilme(Integer fil){
		filme.deleteById(fil);
	}
}
