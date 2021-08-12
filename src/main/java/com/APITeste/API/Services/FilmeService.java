package com.APITeste.API.Services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APITeste.API.Repository.AutorRepository;
import com.APITeste.API.Repository.FilmeRepository;
import com.APITeste.API.models.Filme;


@Service
public class FilmeService {
	@Autowired
	FilmeRepository filme;
	@Autowired
	AutorRepository autor;
	
	public Optional<Filme> findById(Integer Id){
		return filme.findById(Id);
	}
	
	public Iterable<Filme> findAll(){
		return filme.findAll();
	}
}
