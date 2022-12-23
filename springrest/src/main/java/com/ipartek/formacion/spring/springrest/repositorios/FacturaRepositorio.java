package com.ipartek.formacion.spring.springrest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.spring.springrest.pojo.Factura;

public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
	
}
