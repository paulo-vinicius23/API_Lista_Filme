package com.APITeste.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.APITeste.API.models.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
}