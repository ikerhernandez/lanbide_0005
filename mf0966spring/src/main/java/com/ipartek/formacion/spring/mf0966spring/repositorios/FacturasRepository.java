package com.ipartek.formacion.spring.mf0966spring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.mf0966spring.entidades.Factura;

@RepositoryRestResource(path = "facturas", collectionResourceRel = "facturas")
public interface FacturasRepository extends PagingAndSortingRepository<Factura, Long>, CrudRepository<Factura,Long> {

}
