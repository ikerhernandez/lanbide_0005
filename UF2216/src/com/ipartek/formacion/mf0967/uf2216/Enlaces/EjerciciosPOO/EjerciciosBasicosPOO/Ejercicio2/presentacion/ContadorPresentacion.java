package com.ipartek.formacion.mf0967.uf2216.Enlaces.EjerciciosPOO.EjerciciosBasicosPOO.Ejercicio2.presentacion;

import static com.ipartek.formacion.mf0967.uf2216.bibliotecas.Consola.gInt;
import static com.ipartek.formacion.mf0967.uf2216.bibliotecas.Consola.pl;

import com.ipartek.formacion.mf0967.uf2216.Enlaces.EjerciciosPOO.EjerciciosBasicosPOO.Ejercicio2.pojos.Contador;

public class ContadorPresentacion {

//	Ejercicio 2 Crea una clase Contador con los métodos 
//	para incrementar y decrementar el contador. 
//	La clase contendrá un constructor por defecto, 
//	un constructor con parámetros, un constructor copia 
//	y los métodos getters y setters.
	
	public static void main(String[] args) {
		
//						CONT 1
		////////////////////////////////////////

		int n1 = gInt("Introduce un valor para inicializar el contador");
		
		pl("\nCONT 1");
		pl("\nValor introducido: "+ n1);
		
//		Utilizar el constructor pasandole el parametro
		Contador cont1 = new Contador(n1);
		
//		Utilizar el metodo incrementar
		cont1.incrementar();
		
//		Mostrar valor actual
		pl("\nMostrando valor tras incrementar el valor introducido en 1");
		pl(cont1.getCont());
		
//		Utilizar el metodo incrementar 2 veces
		cont1.incrementar();
		cont1.incrementar();
		
//		Mostrar valor actual
		pl("Mostrando el valor tras incrementar el valor anterior en 2");
		pl(cont1.getCont());
		
//		Utilizar el metodo decrementar
		cont1.decrementar();
		
//		Mostrar valor actual
		pl("Mostrando el valor tras decrementar el valor anterior en 1");
		pl(cont1.getCont());
		
		
//						CONT 2
		////////////////////////////////////////
		
		int n2 = gInt("Introduce un valor para inicializar el contador");

		pl("\nCONT 2");
		pl("\nValor introducido: "+ n2);
		
//		Utilizar el constructor pasandole el parametro
		Contador cont2 = new Contador(n2);
		
//		Utilizar el metodo incrementar
		cont2.incrementar();
		
//		Mostrar valor actual
		pl("\nMostrando el valor tras incrementar el valor introducido en 1");
		pl(cont2.getCont());
		
//		Utilizar el metodo decrementar
		cont2.decrementar();
		
//		Mostrar valor actual
		pl("Mostrando el valor tras decrementar el valor anterior en 1");
		pl(cont2.getCont());
		
		
//						CONT 3
		////////////////////////////////////////
		
		pl("\nCONT 3");
		
//		Utilizar el constructor copia
		Contador cont3 = new Contador(cont2);
		
//		Mostrar valor actual
		pl("\nMostrando el valor de la copia");
		pl(cont3.getCont());
		
	}

}
