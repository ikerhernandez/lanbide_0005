package com.ipartek.formacion.spring.springrest.accesodatos;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.springrest.pojo.Factura;
import com.ipartek.formacion.spring.springrest.repositorios.FacturaRepositorio;

@Service
public class DaoHibernateFactura implements Dao<Factura> {

	private FacturaRepositorio facturarepo;
	
	public DaoHibernateFactura(FacturaRepositorio facturarepo) {
		super();
		this.facturarepo = facturarepo;
	}
	
	@Override
	public Iterable<Factura> obtenerTodos() {
		return facturarepo.findAll();
	}
	
	@Override
	public Factura obtenerPorId(Long id) {
		Optional<Factura> factura = facturarepo.findById(id);
		if(factura.isPresent()) {
			return factura.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Factura insertar(Factura factura) {
		return facturarepo.save(factura);
	}
	
	@Override
	public Factura editar(Factura factura, Long id) {
		Factura facturaexistente = facturarepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		facturaexistente.setCodigo(factura.getCodigo());
		facturaexistente.setFecha(factura.getFecha());
		facturaexistente.setCliente(factura.getCliente());
		facturaexistente.setEmpleado(factura.getEmpleado());
		
		return facturarepo.save(facturaexistente);
	}
	
	@Override
	public void borrar(Long id) {
		facturarepo.deleteById(id);
	}
}
