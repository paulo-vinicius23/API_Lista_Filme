package com.APITeste.API.Config.Security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import com.APITeste.API.Repository.UsuarioRepository;
import com.APITeste.API.models.Usuario;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{
	
	@Autowired
	private TokenService token;
	
	@Autowired
	private UsuarioRepository usuario;
	
	public AutenticacaoViaTokenFilter(TokenService token, UsuarioRepository usuario){
		this.token = token;
		this.usuario = usuario;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String tok = recuperarToken(request);
		boolean valido = token.isTokenValido(tok);
		if (valido) {
			autenticarCliente(tok);
		}
		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String tok) {
		Long idUsuario = token.getIdUsuario(tok);
		Usuario Uso = usuario.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken autentc = new UsernamePasswordAuthenticationToken(Uso, null, Uso.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(autentc);
	}

	private String recuperarToken(HttpServletRequest request) {
		String tok = request.getHeader("Authorization");
		if (tok == null || tok.isEmpty() || !tok.startsWith("Bearer ")){
			return null;
		}
		return tok.substring(7, tok.length());
	}
}