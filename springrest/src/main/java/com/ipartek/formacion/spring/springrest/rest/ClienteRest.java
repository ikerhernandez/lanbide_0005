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
import com.ipartek.formacion.spring.springrest.pojo.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRest {

	private Dao<Cliente> clienteService;
	
	public ClienteRest(Dao<Cliente> clienteService) {
		super();
		this.clienteService=clienteService;
	}
	
	@GetMapping
	public Iterable<Cliente> obtenerTodos(){
		return clienteService.obtenerTodos();
	}

	@GetMapping("/{id}")
	public Cliente obtenerPorId(@PathVariable Long id) {
		return clienteService.obtenerPorId(id);
	}

	@PostMapping
	public ResponseEntity<Cliente> insertar(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteService.insertar(cliente), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> editar(@PathVariable Long id, @RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteService.editar(cliente, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable Long id) {
		clienteService.borrar(id);
	}
}
