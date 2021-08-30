package com.APITeste.API.Config.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public AutentcService AutSer;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(AutSer).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/todos-filmes").permitAll()
		.antMatchers(HttpMethod.GET, "/todas-categorias").permitAll()
		.antMatchers(HttpMethod.GET, "/filme-nome/*").permitAll()
		.antMatchers(HttpMethod.GET, "/filme-categoria/*").permitAll()
		.anyRequest().authenticated()
		.and().formLogin();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
	}
}
