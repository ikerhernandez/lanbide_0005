package com.ipartek.formacion.mf0967.uf2216.Enlaces.EjerciciosBasicos.EjerciciosGenerales;

import java.util.Scanner;

public class Ejercicio6 {

//	Ejercicio 6 Comprobar si un número es perfecto
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int i, num, suma = 0;
		
		System.out.println("Introduce un numero");
		num = sc.nextInt();
		
		for(i = 1; i < num; i++) {
			if (num % i == 0) {
				suma = suma + i;
			}
		}
		
		if(suma == num) {
			System.out.println("Perfecto");
		}else {
			System.out.println("No es perfecto");
		}
	}

}
