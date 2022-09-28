package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Excepciones1.presentacion;

import java.util.Scanner;

public class Excepciones1presentacion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b;
		
		System.out.println("Introduce el numero A");
		a=sc.nextInt();
		System.out.println("Introduce el numero B");
		b=sc.nextInt();
		
		try {
			System.out.println(a/b);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
