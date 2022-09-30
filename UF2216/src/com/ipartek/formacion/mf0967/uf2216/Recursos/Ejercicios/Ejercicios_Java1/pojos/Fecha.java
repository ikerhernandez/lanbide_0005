package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Ejercicios_Java1.pojos;

import java.util.GregorianCalendar;

public class Fecha {

//	-------------------------Variables
	private int año = 0;
	private int mes = 1;
	private int dia = 1;
	
	public static final int MESES_AÑO = 12;
	
	public static boolean esBisiesto(int año) {
		GregorianCalendar calendar = new GregorianCalendar();
		return calendar.isLeapYear(año);
	}

//	-------------------------Contructores
	public Fecha() {}

	public Fecha(int año, int mes, int dia) {
		
		if(esBisiesto(año)) {
			if(mes == 2) {
				if(dia > 29) {
					throw new FechaException("Febrero en año bisiesto no puede tener mas de 29 dias");
				}
			}
		}else{
			if(mes == 2) {
				if(dia > 28) {
					throw new FechaException("Febrero en año no bisiesto no puede tener mas de 28 dias");
				}
			}			
		}
		
		this.año = año;
		this.mes = mes;
		this.dia = dia;
	}
	
//	-------------------------Getters && Setters
	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		if(mes < 1 && mes > 12) {
			throw new FechaException("El mes no puede ser menor que 1 o mayor que 12");
		}
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public boolean esBisiesto() {
		return esBisiesto(año);
	}
	
	public void set(int año, int mes, int dia) {
		
	}
	
	public void set(Fecha f) {
		
	}
	
	@Override
	public String toString() {
		return "Fecha [año=" + año + ", mes=" + mes + ", dia=" + dia + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	
	
}
