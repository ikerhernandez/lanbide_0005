package com.ipartek.formacion.mf0967.uf2216.EjerciciosSobreRecursividad;

import java.util.Scanner;

public class Ejercicio1 {

//	Ejercicio 9 Calcular el cociente de dos números enteros de forma recursiva.
	public static void main(String[] args) {

        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        int n1, n2;
        System.out.print("Introduzca dividendo: ");
        n1 = sc.nextInt();
        do {
            System.out.print("Introduzca divisor (>0): ");
            n2 = sc.nextInt();
        } while (n1 <= 0);
        System.out.printf("%d/%d = %d %n", n1, n2, cociente(n1, n2));
    }

    public static int cociente(int a, int b) {
        if (a < b)
            return 0;
        else
            return 1 + cociente(a - b, b);
	}

}
