package com.ipartek.formacion.spring.springrest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.springrest.accesodatos.Dao;
import com.ipartek.formacion.spring.springrest.pojo.Producto;

@RestController
@RequestMapping("/api/productos")
public class ProductoRest {

	private Dao<Producto> productoService;
	
	public ProductoRest(Dao<Producto> productoService) {
		super();
		this.productoService=productoService;
	}
	
	@GetMapping
	public Iterable<Producto> obtenerTodos(){
		return productoService.obtenerTodos();
	}

	@GetMapping("/{id}")
	public Producto obtenerPorId(@PathVariable Long id) {
		return productoService.obtenerPorId(id);
	}

	@PostMapping
	public ResponseEntity<Producto> insertar(@RequestBody Producto producto){
		return new ResponseEntity<Producto>(productoService.insertar(producto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> editar(@PathVariable Long id, @RequestBody Producto producto){
		return new ResponseEntity<Producto>(productoService.editar(producto, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable Long id) {
		productoService.borrar(id);
	}
}
