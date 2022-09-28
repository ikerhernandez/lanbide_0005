package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Excepciones2.presentacion;

import java.util.Scanner;

public class Excepciones2presentacion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String numeroleido;

		
		numeroleido=sc.nextLine();
		
		try {
			Integer.parseInt(numeroleido);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Error");
		}
		
//		System.out.println(numeroleido);
	}

}
