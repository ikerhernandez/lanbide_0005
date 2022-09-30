package com.ipartek.formacion.mf0967.uf2216.Enlaces.EjerciciosBasicos.EjerciciosGenerales;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

//	Ejercicio 2 Calcular en número de cifras de un número entero
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int num, cifras;
		char car;
		
		do{
			cifras = 0;
			
			System.out.println("Introduce un numero");
			num = sc.nextInt();
			
			while(num!=0) {
				num = num / 10;
				cifras++;
			}
			
			System.out.println("El numero que has introducido tiene " + cifras + " cifras");
			
			System.out.println("Continuar? S/N");
			car = (char)System.in.read();
			
			System.out.println(car);
			
		}while (car!='N' && car!='n');
	}

}
