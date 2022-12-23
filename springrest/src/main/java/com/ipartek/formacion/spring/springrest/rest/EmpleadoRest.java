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
import com.ipartek.formacion.spring.springrest.pojo.Empleado;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRest {

	private Dao<Empleado> empleadoService;
	
	public EmpleadoRest(Dao<Empleado> empleadoService) {
		super();
		this.empleadoService=empleadoService;
	}
	
	@GetMapping
	public Iterable<Empleado> obtenerTodos(){
		return empleadoService.obtenerTodos();
	}

	@GetMapping("/{id}")
	public Empleado obtenerPorId(@PathVariable Long id) {
		return empleadoService.obtenerPorId(id);
	}

	@PostMapping
	public ResponseEntity<Empleado> insertar(@RequestBody Empleado empleado){
		return new ResponseEntity<Empleado>(empleadoService.insertar(empleado), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Empleado> editar(@PathVariable Long id, @RequestBody Empleado empleado){
		return new ResponseEntity<Empleado>(empleadoService.editar(empleado, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable Long id) {
		empleadoService.borrar(id);
	}
}
