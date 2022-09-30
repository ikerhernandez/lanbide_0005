package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Ejercicios_Java2.pojos;

public class EntradaEstandar {

	public static int leerInt(String mensaje) {

		int i = 0;

		i = Integer.parseInt(mensaje);

		return i;
	}
	
	public static float leerFloat(String mensaje) {
		return Float.parseFloat(mensaje);
		
	}
	
	public static String leerString(String mensaje) {
		
		return mensaje;
		
	}
}
