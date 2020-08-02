package com.creacionesLilha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creacionesLilha.model.Producto;

@Repository
public interface productoRepository extends JpaRepository<Producto,Long>{

}
