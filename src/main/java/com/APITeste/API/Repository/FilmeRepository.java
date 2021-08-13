package com.APITeste.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import com.APITeste.API.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer>{
}
