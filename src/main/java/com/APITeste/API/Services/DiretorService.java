package com.APITeste.API.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APITeste.API.Repository.DiretorRepository;
import com.APITeste.API.models.Diretor;

@Service
public class DiretorService {
	
	@Autowired
	DiretorRepository diretor;
	
	public Optional<Diretor> findById(Integer Id){
		return diretor.findById(Id);
	}
	
	public List<Diretor> findAll(){
		return diretor.findAll();
	}
	
	public Diretor saveDiretor(Diretor aut){
		return diretor.save(aut);
	}
	
	public void deleteDiretor(Integer aut){
		diretor.deleteById(aut);
	}
}
