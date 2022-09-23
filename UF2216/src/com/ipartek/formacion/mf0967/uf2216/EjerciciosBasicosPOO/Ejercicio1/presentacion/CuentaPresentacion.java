package com.ipartek.formacion.mf0967.uf2216.EjerciciosBasicosPOO.Ejercicio1.presentacion;

import java.util.Scanner;

import com.ipartek.formacion.mf0967.uf2216.EjerciciosBasicosPOO.Ejercicio1.pojos.Cuenta;

public class CuentaPresentacion {

//	Ejercicio 1 Crea una clase Cuenta con los métodos ingreso, 
//	reintegro y transferencia. La clase contendrá un constructor por defecto, 
//	un constructor con parámetros, un constructor copia y los métodos getters y setters.
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		Cuenta cuenta1 = new Cuenta();
		
		String nombre, numcuenta;
		double interes, saldo;
		
		System.out.println("Introduce los datos de la cuenta");
		System.out.print("Nombre: ");
		nombre = sc.nextLine();
		System.out.print("Numero de cuenta: ");
		numcuenta = sc.nextLine();
		System.out.print("Tipo de interés: ");
		interes = sc.nextDouble();
		System.out.print("Saldo: ");
		saldo = sc.nextDouble();
		
//		System.out.println(nombre + " " + numcuenta + " " + interes + " " + saldo);
		
		cuenta1.setNombre(nombre);
		cuenta1.setNumcuenta(numcuenta);
		cuenta1.setInteres(interes);
		cuenta1.setSaldo(saldo);
		
		Cuenta cuenta2 = new Cuenta("Javier","54321",3,30000);
		
		
		Cuenta cuenta3 = new Cuenta(cuenta1);
		
		
//		mostrar los datos de cuenta1
		System.out.println("Datos de la cuenta 1");
		System.out.println("Nombre del titular: " + cuenta1.getNombre());
		System.out.println("Número de cuenta: " + cuenta1.getNumcuenta());
		System.out.println("Tipo de interés: " + cuenta1.getInteres());
		System.out.println("Saldo: " + cuenta1.getSaldo());
		System.out.println();
		
		
//		Se realiza un ingreso en cuenta1
		cuenta1.ingreso(400);
		
		
//		Mostrar saldo de cuenta1 despues del ingreso
		System.out.println(cuenta1.getSaldo());
		
		
//		mostrar los datos de cuenta2
		System.out.println("Datos de la cuenta 2");
		System.out.println("Nombre del titular: " + cuenta2.getNombre());
		System.out.println("Número de cuenta: " + cuenta2.getNumcuenta());
		System.out.println("Tipo de interés: " + cuenta2.getInteres());
		System.out.println("Saldo: " + cuenta2.getSaldo());
		System.out.println();
		
		
//		mostrar los datos de cuenta3
		System.out.println("Datos de la cuenta 3");
		System.out.println("Nombre del titular: " + cuenta3.getNombre());
		System.out.println("Número de cuenta: " + cuenta3.getNumcuenta());
		System.out.println("Tipo de interés: " + cuenta3.getInteres());
		System.out.println("Saldo: " + cuenta3.getSaldo());
		System.out.println();

		
//		Se realiza una transferencia de 10€ desde cuenta3 a cuenta2
		cuenta3.transferencia(cuenta2, 10);
		
		
//		 mostrar el saldo de cuenta2
		 System.out.println("Saldo de la cuenta 2");
		 System.out.println("Saldo: " + cuenta2.getSaldo());
		 System.out.println();
		
		
//		 mostrar el saldo de cuenta3
		 System.out.println("Saldo de la cuenta 3");
		 System.out.println("Saldo: " + cuenta3.getSaldo());
		 System.out.println();
		 
		 
	}

}
