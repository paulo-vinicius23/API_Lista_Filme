package com.APITeste.API.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.APITeste.API.models.Categoria;
import com.APITeste.API.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer>{
	
	@Query("SELECT f FROM Filme f WHERE LOWER(f.filme) LIKE LOWER(CONCAT('%',:filme,'%'))")
	List<Filme> searchName(String filme);
	
	List<Filme> findByCategoria(Categoria categoria);

	void deleteById(Long fil);

	Optional<Filme> findById(Long id);
}
