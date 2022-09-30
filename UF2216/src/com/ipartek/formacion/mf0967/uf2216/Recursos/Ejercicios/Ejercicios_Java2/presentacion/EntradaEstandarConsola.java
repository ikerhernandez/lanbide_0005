package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Ejercicios_Java2.presentacion;

import java.io.IOException;

import com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Ejercicios_Java2.pojos.EntradaEstandar;
import static com.ipartek.formacion.mf0967.uf2216.bibliotecas.Consola.*;

public class EntradaEstandarConsola {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		
		java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
		java.io.BufferedReader br = new java.io.BufferedReader(isr); 

		EntradaEstandar es = new EntradaEstandar();
		
		boolean correcto;
		int en1 = 0, en2 = 0;
		float fl1 = 0, fl2 = 0;
		String nombre = null;
		
		correcto = false;
		
		do {
			try {
				p("Operando entero 1: ");
				String c = br.readLine();
				en1 = es.leerInt(c);
				correcto = true;
			} catch (Exception e) {
				pl("ERROR: El valor introducido no es correcto.");
			} 
		} while (!correcto);
		
		correcto = false;
		
		do {
			try {
				p("Operando entero 2: ");
				String c = br.readLine();
				en2 = es.leerInt(c);
				correcto = true;
			} catch (Exception e) {
				pl("ERROR: El valor introducido no es correcto.");
			} 
		} while (!correcto);

		pl("Resultado: "+en1+" + "+en2+" = "+(en1+en2));
		
		correcto = false;
		
		do {
			try {
				p("Operando flotante 1: ");
				String c = br.readLine();
				fl1 = es.leerFloat(c);
				correcto = true;
			} catch (Exception e) {
				pl("ERROR: El valor introducido no es correcto.");
			} 
		} while (!correcto);
		
		correcto = false;
		
		do {
			try {
				p("Operando flotante 2: ");
				String c = br.readLine();
				fl2 = es.leerFloat(c);
				correcto = true;
			} catch (Exception e) {
				pl("ERROR: El valor introducido no es correcto.");
			} 
		} while (!correcto);
		
		pl("Resultado: "+fl1+" / "+fl2+" = "+(fl1/fl2));
		
		correcto = false;
		
		do {
			try {
				p("Introduzca su nombre: ");
				String c = br.readLine();
				nombre = es.leerString(c);
				correcto = true;
			} catch (Exception e) {
				pl("ERROR: El valor introducido no es correcto.");
			} 
		} while (!correcto);

		pl("Hola "+nombre+". ¡Bienvenido a Java!");
	}

}
