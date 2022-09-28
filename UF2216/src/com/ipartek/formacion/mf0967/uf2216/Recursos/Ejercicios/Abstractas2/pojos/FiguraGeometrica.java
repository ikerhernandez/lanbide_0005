package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas2.pojos;

public abstract class FiguraGeometrica {
	
//	-----------------------Variables
	private String nombre;

//	-----------------------Constructores
	public FiguraGeometrica() {
		
	}
	
	public FiguraGeometrica(String nombre) {
		this.nombre = nombre;
	}
	
//	-----------------------Getters & Setters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
//	-----------------------Metodos abstractos
	public abstract String calcularArea();

	public abstract String calcularPerimetro();

	public abstract String mostrarInfo();

}
