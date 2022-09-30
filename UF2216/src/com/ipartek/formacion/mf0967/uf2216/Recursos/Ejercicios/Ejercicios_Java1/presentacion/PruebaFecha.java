package com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Ejercicios_Java1.presentacion;

import com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Ejercicios_Java1.pojos.Fecha;

public class PruebaFecha {
	public static final int MAX_FECHAS = 100;

	public static int random(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	public static void main(String[] args) {
		for (int i = 0; i < MAX_FECHAS; i++) {
			try {
				Fecha f = new Fecha(random(1, 2007), random(1, Fecha.MESES_AÑO), random(1, 31));
				System.out.println("Fecha correcta: " + f.toString());
			} catch (Exception e) {
				System.out.println("EXCEPTION: " + e.getMessage());
			}
		}
	}
}