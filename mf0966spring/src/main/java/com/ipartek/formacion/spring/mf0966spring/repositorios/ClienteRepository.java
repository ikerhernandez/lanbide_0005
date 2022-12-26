package com.ipartek.formacion.spring.mf0966spring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.mf0966spring.entidades.Cliente;
import com.ipartek.formacion.spring.mf0966spring.entidades.Factura;

@RepositoryRestResource(path = "clientes", collectionResourceRel = "clientes")
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>, CrudRepository<Cliente,Long> {
	public Cliente findByNombre(String nombre);
	
	@Query("from Cliente where nombre = :nombre")
	public Cliente getByNombre(String nombre);
	
	@Query("from Factura where cliente.id = :id")
	public List<Factura> getByCliente(Long id);
}
