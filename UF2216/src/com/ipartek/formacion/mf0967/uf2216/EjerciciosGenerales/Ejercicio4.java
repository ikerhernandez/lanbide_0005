package com.ipartek.formacion.mf0967.uf2216.EjerciciosGenerales;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

//	Ejercicio 4 Mostrar la tabla de multiplicar de un número
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int num;
		char car;
		
		do {
			
			System.out.println("Introduce un número");
			num = sc.nextInt();
			
			System.out.println("Mostrando la tabla de multiplicar del número: " + num);
			
			for (int i = 0; i <= 10; i++) {
				
				System.out.println(i + " x " + num + " = " + (i*num));
			}
			
			System.out.println("Probar con otro número? S/N");
			car=(char)System.in.read();
			
		} while (car=='S' || car=='s');
	}

}
