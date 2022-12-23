package com.ipartek.formacion.spring.springrest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.spring.springrest.pojo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
	
}
