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
import com.ipartek.formacion.spring.springrest.pojo.Factura;

@RestController
@RequestMapping("/api/facturas")
public class FacturaRest {

	private Dao<Factura> facturaService;
	
	public FacturaRest(Dao<Factura> facturaService) {
		super();
		this.facturaService=facturaService;
	}
	
	@GetMapping
	public Iterable<Factura> obtenerTodos(){
		return facturaService.obtenerTodos();
	}

	@GetMapping("/{id}")
	public Factura obtenerPorId(@PathVariable Long id) {
		return facturaService.obtenerPorId(id);
	}

	@PostMapping
	public ResponseEntity<Factura> insertar(@RequestBody Factura factura){
		return new ResponseEntity<Factura>(facturaService.insertar(factura), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Factura> editar(@PathVariable Long id, @RequestBody Factura factura){
		return new ResponseEntity<Factura>(facturaService.editar(factura, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable Long id) {
		facturaService.borrar(id);
	}
}
