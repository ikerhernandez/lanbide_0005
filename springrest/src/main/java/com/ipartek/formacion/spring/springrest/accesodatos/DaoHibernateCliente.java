package com.ipartek.formacion.spring.springrest.accesodatos;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.springrest.pojo.Cliente;
import com.ipartek.formacion.spring.springrest.repositorios.ClienteRepositorio;

@Service
public class DaoHibernateCliente implements Dao<Cliente> {

	private ClienteRepositorio clienterepo;
	
	public DaoHibernateCliente(ClienteRepositorio clienterepo) {
		super();
		this.clienterepo = clienterepo;
	}
	
	@Override
	public Iterable<Cliente> obtenerTodos() {
		return clienterepo.findAll();
	}
	
	@Override
	public Cliente obtenerPorId(Long id) {
		Optional<Cliente> cliente = clienterepo.findById(id);
		if(cliente.isPresent()) {
			return cliente.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		return clienterepo.save(cliente);
	}
	
	@Override
	public Cliente editar(Cliente cliente, Long id) {
		Cliente clienteexistente = clienterepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		clienteexistente.setNombre(cliente.getNombre());
		clienteexistente.setNif(cliente.getNif());
		clienteexistente.setEmail(cliente.getEmail());
		
		return clienterepo.save(clienteexistente);
	}
	
	@Override
	public void borrar(Long id) {
		clienterepo.deleteById(id);
	}
}
