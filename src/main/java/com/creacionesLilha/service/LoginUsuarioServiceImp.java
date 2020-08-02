package com.creacionesLilha.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.creacionesLilha.model.Usuario;
import com.creacionesLilha.repository.usuarioRepository;


@Service
public class LoginUsuarioServiceImp implements UserDetailsService{

	@Autowired
	usuarioRepository iUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = iUsuario.findByCorreo(correo).orElseThrow(()-> new UsernameNotFoundException("Usuario Invalido"));
		
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipoUsuario());
		tipos.add(grantedAuthority);
		
		UserDetails user = (UserDetails) new User(correo, usuarioEncontrado.getPassword(),tipos);
		return user;
	}
}
