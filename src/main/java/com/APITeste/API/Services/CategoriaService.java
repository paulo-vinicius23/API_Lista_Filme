package com.APITeste.API.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APITeste.API.Repository.CategoriaRepository;
import com.APITeste.API.models.Categoria;

@Service
public class CategoriaService{
	
	@Autowired
	CategoriaRepository categoria;

	
	public Optional<Categoria> findById(Integer Id){
		return categoria.findById(Id);
	}
	
	public List<Categoria> findAll(){
		return categoria.findAll();
	}
	
	public Categoria saveCategoria(Categoria cat){
		return categoria.save(cat);
	}
	
	public void deleteCategoria(Integer cat){
		categoria.deleteById(cat);
	}
}
