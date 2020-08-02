package com.creacionesLilha.service;

import org.springframework.stereotype.Service;

import com.creacionesLilha.model.Usuario;


@Service
public interface usuarioService {
	
	public void guardarUsuario(Usuario usuario);
}
