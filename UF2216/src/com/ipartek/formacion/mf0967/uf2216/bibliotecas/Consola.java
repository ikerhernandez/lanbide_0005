package com.ipartek.formacion.mf0967.uf2216.bibliotecas;

import java.util.Scanner;

public class Consola {

	private static final Scanner SC = new Scanner(System.in);
	
	public static void pl(Object o) {
		System.out.println(o);
	}
	public static void p(Object o) {
		System.out.print(o);
	}
	
	public static String gString(String mensaje) {
		p(mensaje + ": ");
		return SC.nextLine();
	}
	
	public static int gInt(String mensaje) {
		
		boolean correcto = false;
		int i = 0;
		
		do {
			try {
				String texto = gString(mensaje);
				i = Integer.parseInt(texto);
				correcto = true;
			} catch (NumberFormatException e) {
				pl("No es un numero valido");
			} 
		} while (!correcto);
		
		return i;
	}
	
}
