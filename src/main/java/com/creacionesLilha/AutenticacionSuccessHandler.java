package com.creacionesLilha;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AutenticacionSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		boolean tipoCliente = false;
		boolean tipoVendedor = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("Cliente")) {
				tipoCliente = true;
				
				break;
			}else {
				if(grantedAuthority.getAuthority().equals("Vendedor")) {
					tipoVendedor = true;
					break;
				}
				
			}
		}
		if(tipoCliente) {
			redirectStrategy.sendRedirect(request, response, "/productos");
		}else {
			if(tipoVendedor) {
				redirectStrategy.sendRedirect(request, response, "/agregarProducto");
			}else {
					throw new IllegalStateException();
				}
			}
		}
	}