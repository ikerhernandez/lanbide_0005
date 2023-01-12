package com.ipartek.formacion.spring.mf0966spring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.mf0966spring.entidades.Linea;

@RepositoryRestResource(path = "lineas", collectionResourceRel = "lineas")
public interface LineasRepository extends PagingAndSortingRepository<Linea, Long>, CrudRepository<Linea,Long> {

}
