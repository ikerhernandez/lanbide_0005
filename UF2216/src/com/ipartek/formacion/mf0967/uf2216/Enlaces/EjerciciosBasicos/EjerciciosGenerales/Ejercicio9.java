package com.ipartek.formacion.mf0967.uf2216.Enlaces.EjerciciosBasicos.EjerciciosGenerales;

import java.util.Scanner;

public class Ejercicio9 {

//	Ejercicio 9 Pasar de decimal a binario
	public static void main(String[] args) {
		
        int numero, exp, digito;
        double binario;
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        do{ 
            System.out.print("Introduce un numero entero >= 0: ");                                                
            numero = sc.nextInt();
        }while(numero < 0);

        exp=0;
        binario=0;
        while(numero!=0){
                digito = numero % 2;           
                binario = binario + digito * Math.pow(10, exp);                                                   
                exp++;
                numero = numero/2;
        }
        System.out.printf("Binario: %.0f %n", binario);
	}

}
