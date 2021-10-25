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
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
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
	private Long id;

	@ManyToMany(fetch = FetchType.EAGER) @NotBlank @NotEmpty
	public List<Perfil> PerfilList = new ArrayList<>(); 
			
	@Column(name = "Nome") @NotBlank @NotEmpty
	private String nome;
			
	@Column(name = "Cpf") @NotBlank @NotEmpty @Length(min = 14, max = 14)
	private String cpf;
			
	@Column(name = "Telefone") @NotBlank @NotEmpty @Length(min = 11,max = 14)
	private String telefone;
			
	@Column(name = "Email") @NotBlank @NotEmpty
	private String email;
			
	@Column(name = "Perfil") @NotBlank @NotEmpty
	private String perfil;
			
	@Column(name = "Senha") @NotBlank @NotEmpty @Length(min = 8)
	private String senha;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
