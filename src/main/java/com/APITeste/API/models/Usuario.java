package com.APITeste.API.models;

import java.util.ArrayList; 
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public int id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	public List<Perfil> PerfilList = new ArrayList<>(); 
			
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
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return PerfilList;
	}
	
	@Override
	public String getPassword(){
		return this.senha;
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}
