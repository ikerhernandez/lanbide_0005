package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas2.pojos;

import java.math.BigDecimal;

public class Cuadrado extends FiguraGeometrica {

	
//	----------------------------------------Variables
	private int lado;
	
//	----------------------------------------Constructores
	public Cuadrado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cuadrado(int nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	
//	----------------------------------------Getters & Setters
	public int getLado() {
		return lado;
	}
	
	public void setLado(int lado) {
		this.lado = lado;
	}
	
	
	
	
	
	
	
	
	

	//	----------------------------------------Metodos abstractos
	@Override
	public BigDecimal calcularArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal calcularPerimetro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal mostrarInfo() {
		// TODO Auto-generated method stub
		return null;
	}


}
