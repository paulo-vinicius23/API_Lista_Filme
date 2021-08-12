package com.APITeste.API.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.APITeste.API.models.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer>{
}