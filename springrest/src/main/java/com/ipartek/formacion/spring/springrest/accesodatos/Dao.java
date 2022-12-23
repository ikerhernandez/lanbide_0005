package com.ipartek.formacion.spring.springrest.accesodatos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new UnsupportedOperationException("No está implementada esta operación");
	}
	default T obtenerPorId(Long id) {
		throw new UnsupportedOperationException("No está implementada esta operación");
	}
	default T insertar(T objeto) {
		throw new UnsupportedOperationException("No está implementada esta operación");
	}
	default T editar(T objeto, Long id) {
		throw new UnsupportedOperationException("No está implementada esta operación");
	}
	default void borrar(Long id) {
		throw new UnsupportedOperationException("No está implementada esta operación");
	}
}
