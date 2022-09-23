package com.ipartek.formacion.mf0967.uf2216.EjerciciosBasicosPOO.Ejercicio2.pojos;

public class Contador {

//					VARIABLES
	////////////////////////////////////////////////
	
	private int cont;
	
	
//					CONSTRUCTORES
	////////////////////////////////////////////////
	
//	Constructor por defecto
	public Contador() {
		
	}	
	
//	Constructor con parámetros
	public Contador(int cont) {
		if(cont < 0) {
			this.cont = 0;
		}else {
			this.cont = cont;
		}
	}
	
//	Constructor copia
	public Contador(final Contador c) {
		cont = c.cont;
	}

//					SETTER && GETTER
	////////////////////////////////////////////////
	
	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		if(cont < 0) {
			this.cont = 0;
		}else {
			this.cont = cont;
		}
	}
	
//					METODOS
	////////////////////////////////////////////////
	
//	Metodo incrementar
	public void incrementar() {
		cont++;
	}
	
//	Metodo decrementar
	public void decrementar() {
		cont--;
		if(cont < 0) {
			cont = 0;
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
}
