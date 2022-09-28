package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas2.pojos;

public class Triangulo extends FiguraGeometrica implements Formulas {

//	-----------------------------Variables
	private double base;
	private double altura;
	
	
//	-----------------------------Constructores
	public Triangulo() {
		
	}
	
	public Triangulo(String nombre, double base, double altura) {
		super(nombre);
		this.base = base;
		this.altura = altura;		
	}

//	-----------------------------Getters & Setters
	public double getBase() {
		return base;
	}
	
	public void setBase(double base) {
		this.base = base;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
//	-----------------------------Funciones
	public double area() {
		return (base*altura)/2;
	}
	
	public double perimetro() {
		return Math.sqrt((base*base)+(altura*altura));
	}

//	-----------------------------Metodos abstractos
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
