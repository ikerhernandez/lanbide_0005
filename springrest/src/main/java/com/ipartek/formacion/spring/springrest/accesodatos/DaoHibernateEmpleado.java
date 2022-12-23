package com.ipartek.formacion.spring.springrest.accesodatos;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.springrest.pojo.Empleado;
import com.ipartek.formacion.spring.springrest.repositorios.EmpleadoRepositorio;

@Service
public class DaoHibernateEmpleado implements Dao<Empleado> {

	private EmpleadoRepositorio empleadorepo;
	
	public DaoHibernateEmpleado(EmpleadoRepositorio empleadorepo) {
		super();
		this.empleadorepo = empleadorepo;
	}
	
	@Override
	public Iterable<Empleado> obtenerTodos() {
		return empleadorepo.findAll();
	}
	
	@Override
	public Empleado obtenerPorId(Long id) {
		Optional<Empleado> empleado = empleadorepo.findById(id);
		if(empleado.isPresent()) {
			return empleado.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Empleado insertar(Empleado empleado) {
		return empleadorepo.save(empleado);
	}
	
	@Override
	public Empleado editar(Empleado empleado, Long id) {
		Empleado empleadoexistente = empleadorepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		empleadoexistente.setNombre(empleado.getNombre());
		empleadoexistente.setNif(empleado.getNif());
		empleadoexistente.setJefe(empleado.getJefe());
		
		return empleadorepo.save(empleadoexistente);
	}
	
	@Override
	public void borrar(Long id) {
		empleadorepo.deleteById(id);
	}
}
