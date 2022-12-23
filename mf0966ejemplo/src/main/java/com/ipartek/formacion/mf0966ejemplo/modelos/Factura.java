package com.ipartek.formacion.mf0966ejemplo.modelos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura extends Pedido{
	private Long id;
	private String codigo;
	private LocalDate fecha;

	private Cliente cliente;
	private Empleado empleado;

	public Factura(Pedido pedido) {
		this.lineas = pedido.lineas;
	}
	
	private Set<Linea> lines = new HashSet<>();
	
//	@Data
//	@AllArgsConstructor
//	@NoArgsConstructor
//	public static class Linea {
//		private Factura factura;
//		private Producto producto;
//		private Integer cantidad;
//	}
}
