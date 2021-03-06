package com.APITeste.API.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

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
	public Long id;
	
	@Column(name = "Filme") @NotBlank @NotEmpty @Length(min = 2)
	public String filme;
	
	@Column(name = "Ano") @NotBlank @NotEmpty
	public String ano;
	
	@Column(name = "Imagem") @NotBlank @NotEmpty
	public String imagem;
	
	@Column(name = "Sinopse") @NotBlank @NotEmpty @Length(max = 500)
	public String sinopse;
	
	@Column(name = "Duração") @NotBlank @NotEmpty
	public String duracao;
	
	@Column(name = "Diretor") @NotBlank @NotEmpty
	public String diretor;
	
	@ManyToOne
	public Categoria categoria;
}
