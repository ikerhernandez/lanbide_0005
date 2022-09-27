package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas1.pojos;

import java.math.BigDecimal;

public class JuegoMesa extends Juego {

	
//	---------------------------Variables
	private int numerominjugadores;
	private int numeromaxjugadores;
	
//	---------------------------Constructores
	public JuegoMesa() {
		
	}
	
	public JuegoMesa(String nombre, int edadminima, int numerominjugadores, int numeromaxjugadores) {
		super(nombre, edadminima);
		setNumerominjugadores(numerominjugadores);
		setNumeromaxjugadores(numeromaxjugadores);
	}
	
//	---------------------------Setters & Getters
	public int getNumerominjugadores() {
		return numerominjugadores;
	}
	
	public void setNumerominjugadores(int numerominjugadores) {
		this.numerominjugadores = numerominjugadores;
	}
	
	public int getNumeromaxjugadores() {
		return numeromaxjugadores;
	}
	
	public void setNumeromaxjugadores(int numeromaxjugadores) {
		this.numeromaxjugadores = numeromaxjugadores;
	}
	
//	---------------------------Funciones
	

	
	
	
//	---------------------------Metodos abstractos
	@Override
	public String presentarJuego() {
		return getNombre() + ", juego para personas mayores de " + getEdadminima() + " años, juego para " + getNumerominjugadores() + " a " + getNumeromaxjugadores() + " jugadores";
	}


	@Override
	public String iniciarPartida() {
		return "Comenzó una partida de " + getNombre() + ", ¡que comience la diversión!";
	}

//	---------------------------Metodos abstractos
	@Override
	public String toString() {
		return "JuegoMesa [numerominjugadores=" + numerominjugadores + ", numeromaxjugadores=" + numeromaxjugadores
				+ ", getNombre()=" + getNombre() + ", getEdadminima()=" + getEdadminima() + "]";
	}


}
