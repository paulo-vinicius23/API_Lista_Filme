package com.APITeste.API.Services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APITeste.API.Repository.AutorRepository;
import com.APITeste.API.models.Autor;

@Service
public class AutorService {
	
	@Autowired
	AutorRepository autor;
	
	public Optional<Autor> findById(Integer Id){
		return autor.findById(Id);
	}
	
	public Iterable<Autor> findAll(){
		return autor.findAll();
	}
}
