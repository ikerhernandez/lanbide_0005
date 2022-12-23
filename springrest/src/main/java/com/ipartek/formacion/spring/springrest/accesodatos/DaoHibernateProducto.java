package com.ipartek.formacion.spring.springrest.accesodatos;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.springrest.pojo.Producto;
import com.ipartek.formacion.spring.springrest.repositorios.ProductoRepositorio;

@Service
public class DaoHibernateProducto implements Dao<Producto> {

	private ProductoRepositorio productorepo;
	
	public DaoHibernateProducto(ProductoRepositorio productorepo) {
		super();
		this.productorepo = productorepo;
	}
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return productorepo.findAll();
	}
	
	@Override
	public Producto obtenerPorId(Long id) {
		Optional<Producto> producto = productorepo.findById(id);
		if(producto.isPresent()) {
			return producto.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		return productorepo.save(producto);
	}
	
	@Override
	public Producto editar(Producto producto, Long id) {
		Producto productoexistente = productorepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		productoexistente.setNombre(producto.getNombre());
		productoexistente.setDescripcion(producto.getDescripcion());
		
		return productorepo.save(productoexistente);
	}
	
	@Override
	public void borrar(Long id) {
		productorepo.deleteById(id);
	}
}
