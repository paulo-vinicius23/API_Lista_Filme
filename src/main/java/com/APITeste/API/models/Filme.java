package com.APITeste.API.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Filmes")
public class Filme{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public int id;
	
	@Column(name = "Filme", nullable = false)
	public String filme;
	
	@Column(name = "Ano", nullable = false)
	public String ano;
	
	@Column(name = "Imagem", nullable = false)
	public String imagem;
	
	@Column(name = "Sinopse", nullable = false)
	public String sinopse;
	
	@Column(name = "Duração", nullable = false)
	public String duracao;
	
	@Column(name = "Nota", nullable = false)
	public double nota;
	
	@ManyToOne
	public Diretor diretor;
	
	@ManyToOne
	public Categoria categoria;
	
	@ManyToOne
	public Idioma idioma;
}
