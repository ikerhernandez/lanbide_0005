package com.ipartek.formacion.mf0967.uf2216.Enlaces.EjerciciosPOO.EjerciciosBasicosPOO.Ejercicio1.pojos;

public class Cuenta {

	private String nombre;
	private String numcuenta;
	private double interes;
	private double saldo;
	
	
//	Constructores
	public Cuenta() {

	}
	
	public Cuenta(String nombre, String numcuenta, double interes, double saldo) {
		this.nombre = nombre;
		this.numcuenta = numcuenta;
		this.interes = interes;
		this.saldo = saldo;
	}
	
	public Cuenta(final Cuenta c) {
		nombre = c.nombre;
		numcuenta = c.numcuenta;
		interes = c.interes;
		saldo = c.saldo;
	}

//	Getter and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumcuenta() {
		return numcuenta;
	}
	public void setNumcuenta(String numcuenta) {
		this.numcuenta = numcuenta;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
//	Método ingreso
	public boolean ingreso(double n) {
		
		boolean TodoCorrecto = true;
		if(n < 0) {
			TodoCorrecto = false;
		}else {
			saldo = saldo + n;		
		}
		
		return TodoCorrecto;
	}
	
//	Metodo reintegro
	public boolean reintegro(double n) {
		
		boolean TodoCorrecto = true;
		if(saldo < n) {
			TodoCorrecto = false;
		}else {
			saldo = saldo - n;
		}
		
		return TodoCorrecto;
	}
	
//	Metodo transferencia
	public boolean transferencia(Cuenta c, double n) {
		
		boolean TodoCorrecto = true;
		if(saldo < 0) {
			TodoCorrecto = false;
		}else if (saldo > n) {
			reintegro(n);
			c.ingreso(n);
		}else {
			TodoCorrecto = false;
		}
		
		return TodoCorrecto;
	}
	
	
}
