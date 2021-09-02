package com.APITeste.API.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APITeste.API.Repository.DiretorRepository;
import com.APITeste.API.models.Diretor;

@Service
public class DiretorService {
	
	@Autowired
	DiretorRepository diretor;
	
	public Diretor saveDiretor(Diretor dir){
		return diretor.save(dir);
	}

	public void deleteDiretor(Long id) {
		diretor.deleteById(id);
	}
}
