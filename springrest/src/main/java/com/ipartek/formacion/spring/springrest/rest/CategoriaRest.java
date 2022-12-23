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
import com.ipartek.formacion.spring.springrest.pojo.Categoria;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaRest {

	private Dao<Categoria> categoriaService;
	
	public CategoriaRest(Dao<Categoria> categoriaService) {
		super();
		this.categoriaService=categoriaService;
	}
	
	@GetMapping
	public Iterable<Categoria> obtenerTodos(){
		return categoriaService.obtenerTodos();
	}

	@GetMapping("/{id}")
	public Categoria obtenerPorId(@PathVariable Long id) {
		return categoriaService.obtenerPorId(id);
	}

	@PostMapping
	public ResponseEntity<Categoria> insertar(@RequestBody Categoria categoria){
		return new ResponseEntity<Categoria>(categoriaService.insertar(categoria), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> editar(@PathVariable Long id, @RequestBody Categoria categoria){
		return new ResponseEntity<Categoria>(categoriaService.editar(categoria, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable Long id) {
		categoriaService.borrar(id);
	}
}
