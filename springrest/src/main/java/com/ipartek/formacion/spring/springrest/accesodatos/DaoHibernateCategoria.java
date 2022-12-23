package com.ipartek.formacion.spring.springrest.accesodatos;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.springrest.pojo.Categoria;
import com.ipartek.formacion.spring.springrest.repositorios.CategoriaRepositorio;

@Service
public class DaoHibernateCategoria implements Dao<Categoria> {

	private CategoriaRepositorio categoriarepo;
	
	public DaoHibernateCategoria(CategoriaRepositorio categoriarepo) {
		super();
		this.categoriarepo = categoriarepo;
	}
	
	@Override
	public Iterable<Categoria> obtenerTodos() {
		return categoriarepo.findAll();
	}
	
	@Override
	public Categoria obtenerPorId(Long id) {
		Optional<Categoria> categoria = categoriarepo.findById(id);
		if(categoria.isPresent()) {
			return categoria.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Categoria insertar(Categoria cliente) {
		return categoriarepo.save(cliente);
	}
	
	@Override
	public Categoria editar(Categoria categoria, Long id) {
		Categoria categoriaexistente = categoriarepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		categoriaexistente.setNombre(categoria.getNombre());
		categoriaexistente.setDescripcion(categoria.getDescripcion());
		
		return categoriarepo.save(categoriaexistente);
	}
	
	@Override
	public void borrar(Long id) {
		categoriarepo.deleteById(id);
	}
}
