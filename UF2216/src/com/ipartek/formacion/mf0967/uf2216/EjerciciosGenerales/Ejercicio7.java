package com.ipartek.formacion.mf0967.uf2216.EjerciciosGenerales;

import java.util.Scanner;

public class Ejercicio7 {

//	Ejercicio 7 Comprobar si dos números son amigos
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i, suma = 0, num1, num2;
		
		System.out.println("Introduce un número");
		num1 = sc.nextInt();
		System.out.println("Introduce otro número");
		num2 = sc.nextInt();
		
		for(i = 1; i < num1; i++) {
			
			if(num1 % i == 0) {
				
				suma = suma + i;
			}
		}
		
		if(suma == num2) {
			suma = 0;
			for(i = 1; i < num2; i++) {
				
				if(num2 % i == 0) {
					
					suma = suma + i;
				}
			}
			
			if (suma == num1) {
				System.out.println("Son amigos");
			}else {
				System.out.println("No son amigos");
			}
		}else {
			System.out.println("No son amigos");
		}
	}

}
