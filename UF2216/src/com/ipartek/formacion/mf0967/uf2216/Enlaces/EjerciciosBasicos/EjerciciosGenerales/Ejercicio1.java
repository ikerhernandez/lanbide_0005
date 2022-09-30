package com.ipartek.formacion.mf0967.uf2216.Enlaces.EjerciciosBasicos.EjerciciosGenerales;

import java.util.Scanner;

public class Ejercicio1 {

//	Ejercicio 1 Cambiar el contenido de dos variables
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A, B, AUX;
		
		System.out.println("Escriba un numero para la variable A");
		A = sc.nextInt();
		System.out.println("Escriba un numero para la variable B");
		B = sc.nextInt();
		
		sc.close();
		
		System.out.println("El valor de la A es: " + A);
		System.out.println("El valor de la B es: " + B);
		
//		Con variable auxiliar
		AUX = A;
		A = B;
		B = AUX;
		
//		Sin variable auxiliar
		A = A + B;
		B = A - B;
		A = A - B;
		
		System.out.println("Despues de intercambiar el contenido de las variables el resultado es:");
		System.out.println("A: " + A);
		System.out.println("B: " + B);
	}

}
