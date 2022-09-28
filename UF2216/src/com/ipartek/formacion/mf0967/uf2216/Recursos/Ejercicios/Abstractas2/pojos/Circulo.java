package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas2.pojos;

public class Circulo extends FiguraGeometrica implements Formulas {
	
//	-------------------------------------Variables
	private double radio;
	
//	-------------------------------------Constructores
	public Circulo() {
		
	}
	
	public Circulo(String nombre, double radio) {
		super(nombre);
		this.radio = radio;
	}
	
//	-------------------------------------Getters & Setters	
	public double getRadio() {
		return radio;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
//	-------------------------------------Funciones
	public double area() {
		return Math.PI*(radio*radio);
	}
	
	public double perimetro() {
		return 2*Math.PI*radio;
	}
	
//	-------------------------------------Metodos abstractos
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
