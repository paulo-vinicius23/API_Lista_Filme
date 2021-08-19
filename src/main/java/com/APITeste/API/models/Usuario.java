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
@Table(name = "Usuario")
public class Usuario{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "Id")
		public int id;
		
		@Column(name = "Nome", nullable = false)
		public String nome;
		
		@Column(name = "Cpf", nullable = false)
		public String cpf;
		
		@Column(name = "Telefone", nullable = false)
		public String telefone;
		
		@Column(name = "Email", nullable = false)
		public String email;
		
		@Column(name = "Perfil", nullable = false)
		public String perfil;
		
		@Column(name = "Senha", nullable = false)
		public String senha;
		
		@ManyToOne
		public Idioma idioma;
}
