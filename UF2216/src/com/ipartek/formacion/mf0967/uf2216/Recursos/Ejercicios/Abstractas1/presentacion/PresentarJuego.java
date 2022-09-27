package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas1.presentacion;

import java.util.Scanner;

import com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas1.pojos.JuegoMesa;

public class PresentarJuego {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String nombre;
		int edadminima;
		int numerominjugadores;
		int numeromaxjugadores;
		
		JuegoMesa[] juegomesa = new JuegoMesa[3];
		
		for (int i = 0; i < 3; i++) {
			
			System.out.println("Introduce el nombre del juego");
			nombre = sc.next();
			System.out.println("Introduce la edad minima del juego");
			edadminima = sc.nextInt();
			System.out.println("Introduce el numero minimo de jugadores");
			numerominjugadores = sc.nextInt();
			System.out.println("Introduce el numero maximo de jugadores");
			numeromaxjugadores = sc.nextInt();
			
			
			juegomesa[i] = new JuegoMesa(nombre,edadminima,numerominjugadores,numeromaxjugadores);
			
			System.out.println(juegomesa[i].presentarJuego());
		}
		
		int num;
		
		for (int i = 0; i < juegomesa.length; i++) {
			System.out.println(i + " - " + juegomesa[i].getNombre());
		}
		
		System.out.println("Elige un juego para iniciar");
		num = sc.nextInt();
		
		System.out.println(juegomesa[num].iniciarPartida());

	}

}
