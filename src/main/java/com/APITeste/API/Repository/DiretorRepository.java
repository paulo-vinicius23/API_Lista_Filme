package com.APITeste.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.APITeste.API.models.Diretor;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Integer>{

	void deleteById(Long id);
}