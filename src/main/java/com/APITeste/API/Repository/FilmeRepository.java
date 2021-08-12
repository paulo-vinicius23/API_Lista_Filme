package com.APITeste.API.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.APITeste.API.models.Filme;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer>{
}
