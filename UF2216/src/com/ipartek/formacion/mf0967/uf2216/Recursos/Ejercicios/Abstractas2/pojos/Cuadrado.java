package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas2.pojos;

public class Cuadrado extends FiguraGeometrica implements Formulas {

	
//	----------------------------------------Variables
	private double lado;
	
//	----------------------------------------Constructores
	public Cuadrado() {
		
	}
	
	public Cuadrado(String nombre, double lado) {
		super(nombre);
		this.lado = lado;
	}
	
//	----------------------------------------Getters & Setters
	public double getLado() {
		return lado;
	}
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
//	----------------------------------------Funciones
	public double area() {
		return lado*lado;
	}
	
	public double perimetro() {
		return lado*4;
	}
	
//	----------------------------------------Metodos abstractos
	@Override
	public String calcularArea() {
		return "Area de la figura: "+area();
	}

	@Override
	public String calcularPerimetro() {
		return "Perímetro de la figura: "+perimetro();
	}

	@Override
	public String mostrarInfo() {
		return "Nombre de la figura: "+getNombre();
	}


}
