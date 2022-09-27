package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas1.pojos;

import java.math.BigDecimal;

public abstract class Juego {
	
//	---------------------------Variables
	private String nombre;
	private int edadminima;
	
//	---------------------------Constructores
	public Juego() {
		
	}
	
	public Juego(String nombre, int edadminima) {
		super();
		this.nombre = nombre;
		this.edadminima = edadminima;
	}

//	---------------------------Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdadminima() {
		return edadminima;
	}

	public void setEdadminima(int edadminima) {
		this.edadminima = edadminima;
	}

//	---------------------------Funciones abstractas
	public abstract String presentarJuego();
	
	public abstract String iniciarPartida();
	
}
