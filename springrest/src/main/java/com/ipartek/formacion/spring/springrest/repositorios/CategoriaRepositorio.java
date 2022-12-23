package com.ipartek.formacion.spring.springrest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.spring.springrest.pojo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
	
}
