package com.creacionesLilha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.creacionesLilha.model.Usuario;
import com.creacionesLilha.repository.usuarioRepository;



@Service
public class usuarioServiceImp implements usuarioService{

	@Autowired
	usuarioRepository iUsuarioRepository;

	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		String pw = usuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		usuario.setPassword(bCryptPasswordEncoder.encode(pw));
		iUsuarioRepository.save(usuario);
	}
	
	
}
