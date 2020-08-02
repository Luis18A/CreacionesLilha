package com.creacionesLilha.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.creacionesLilha.model.Usuario;

@Repository
public interface usuarioRepository extends JpaRepository<Usuario,Long>{
	public Optional<Usuario> findByCorreo(String correo);
}
