package com.ipartek.formacion.mf0967.uf2216.Enlaces.EjerciciosBasicos.EjerciciosGenerales;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

//	Ejercicio 3 Pasar de grados centígrados a grados kelvin
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		double celsius;
		char car;
		
		do {
			
			System.out.println("Introduce los grados celsius");
			celsius = sc.nextDouble();
			
			System.out.println("Grados Kelvin: " + (celsius + 273));
			System.out.println("Repetir proceso?");
			car = (char)System.in.read();
			
		} while (car=='S' || car=='s');
	}

}
