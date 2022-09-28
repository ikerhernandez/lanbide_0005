package com.ipartek.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.mf0967.uf2216.Recursos.Ejercicios.Abstractas2.pojos.*;

public class FigurasGeometricaspresentacion {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String num, nombre;
		double base, altura, lado, radio;
		
		List<Formulas> formulas = new ArrayList<>();
		
		List<Cuadrado> cuadrado = new ArrayList<>();
		List<Triangulo> triangulo = new ArrayList<>();
		List<Circulo> circulo = new ArrayList<>();
		
		cuadrado.add(new Cuadrado("Cuadrado", 4));
		formulas.addAll(cuadrado);
		
		triangulo.add(new Triangulo("Triangulo",4,4));
		formulas.addAll(triangulo);
		
		circulo.add(new Circulo("Circulo",2));
		formulas.addAll(circulo);
		
		
		for(Formulas f: formulas) {
			
			System.out.println(f);
		}


		do {
			System.out.println("Seleccione un opción:");
			System.out.println("A:crear un triángulo");
			System.out.println("B:crear un cuadrado");
			System.out.println("C:crear un círculo");
			System.out.println("S:salir");
			
			num=sc.nextLine();
			
			if(!num.equals("A") && !num.equals("B") && !num.equals("C") && !num.equals("S")) {
				System.out.println("Error: Número no válido");
			}
			
		} while (!num.equals("A") && !num.equals("B") && !num.equals("C") && !num.equals("S"));
		
		
		
		if(num.equals("S")) {
			for(Formulas f : formulas) {
				
				System.out.println("\n"+f.mostrarInfo());
				System.out.println(f.calcularArea());
				System.out.println(f.calcularPerimetro());
			}
		}else if(num.equals("A")) {
			
			System.out.println("\nHas elegido la opción A");
			System.out.println("Introduce nombre");
			nombre=sc.nextLine();
			System.out.println("Introduce base");
			base=sc.nextDouble();			
			System.out.println("Introduce altura");
			altura=sc.nextDouble();		
			
			triangulo.add(new Triangulo(nombre,base,altura));
			
			for (int i = triangulo.size()-1; i >= 0; i--) {
				
				System.out.println("\n"+triangulo.get(i).mostrarInfo());
				System.out.println(triangulo.get(i).calcularArea());
				System.out.println(triangulo.get(i).calcularPerimetro());
			}
			
			
		}else if(num.equals("B")) {
			
			System.out.println("\nHas elegido la opción B");
			System.out.println("Introduce nombre");
			nombre=sc.nextLine();
			System.out.println("Introduce lado");
			lado=sc.nextDouble();		
			
			cuadrado.add(new Cuadrado(nombre,lado));
			
			for (int i = cuadrado.size()-1; i >= 0; i--) {
				
				System.out.println("\n"+cuadrado.get(i).mostrarInfo());
				System.out.println(cuadrado.get(i).calcularArea());
				System.out.println(cuadrado.get(i).calcularPerimetro());
			}
			
		}else {
			
			System.out.println("\nHas elegido la opción C");
			System.out.println("Introduce nombre");
			nombre=sc.nextLine();
			System.out.println("Introduce radio");
			radio=sc.nextDouble();		
			
			circulo.add(new Circulo(nombre,radio));
			
			for (int i = circulo.size()-1; i >= 0; i--) {
				
				System.out.println("\n"+circulo.get(i).mostrarInfo());
				System.out.println(circulo.get(i).calcularArea());
				System.out.println(circulo.get(i).calcularPerimetro());
			}
		}
		
		

	}

}
