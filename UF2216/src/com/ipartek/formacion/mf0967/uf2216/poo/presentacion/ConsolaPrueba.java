package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import static com.ipartek.formacion.mf0967.uf2216.bibliotecas.Consola.*;

public class ConsolaPrueba {

	public static void main(String[] args) {
		
//		String nombre = gString("Dime tu nombre");
//		
//		pl("Hola " + nombre);
//		
//		Scanner sc = new Scanner(System.in);
		
		int i = gInt("Dame un entero: ");
		
		String s = gString("Dame un texto");

		pl(i + ", " + s);
	}

}
