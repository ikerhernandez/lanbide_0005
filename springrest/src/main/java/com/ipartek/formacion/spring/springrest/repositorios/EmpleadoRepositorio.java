package com.ipartek.formacion.spring.springrest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.spring.springrest.pojo.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
	
}
