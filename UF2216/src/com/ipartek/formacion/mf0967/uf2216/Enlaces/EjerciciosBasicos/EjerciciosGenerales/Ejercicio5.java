package com.ipartek.formacion.mf0967.uf2216.Enlaces.EjerciciosBasicos.EjerciciosGenerales;

import java.util.Scanner;

public class Ejercicio5 {

//	Ejercicio 5 Leer números y contar cuántos acaban en 2
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int num, cont=0;
		
		System.out.println("Introduce un número entero");
		num = sc.nextInt();
		
		while(num>=0) {
			
			if(num%2==0) {
				cont++;
			}
			
			System.out.println("Introduce un número entero");
			num = sc.nextInt();
		}	
		
		System.out.println("Se han introducido " + cont + " acabados en 2");
	}

}
