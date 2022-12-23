package com.ipartek.formacion.mf0966.uf2216.doscapas.entidades;

import java.math.BigDecimal;

import lombok.Data;

public @Data class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Long descuento;
}
