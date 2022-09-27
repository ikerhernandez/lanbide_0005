package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas2.pojos;

import java.math.BigDecimal;

public abstract class FiguraGeometrica {
	
//	-----------------------Variables
	private int nombre;

//	-----------------------Constructores
	public FiguraGeometrica() {
		
	}
	
	public FiguraGeometrica(int nombre) {
		this.nombre = nombre;
	}
	
//	-----------------------Getters & Setters
	public int getNombre() {
		return nombre;
	}
	
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
//	-----------------------Metodos abstractos
	public abstract BigDecimal calcularArea();

	public abstract BigDecimal calcularPerimetro();

	public abstract BigDecimal mostrarInfo();

}
