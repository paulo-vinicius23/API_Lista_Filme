package com.APITeste.API.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.APITeste.API.models.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{
}
