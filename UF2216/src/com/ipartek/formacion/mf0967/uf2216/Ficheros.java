package com.ipartek.formacion.mf0967.uf2216;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheros {

	public static void main(String[] args) throws IOException {

//		String fichero = "C:\\trabajos\\nuevos";
//		String fichero = "C:/trabajos/nuevos";
//		
//		System.out.println(fichero);
		
		String fichero = "datos.txt";
		
		FileWriter fw = new FileWriter(fichero);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("Hola desde el nuevo fichero");
		
		pw.close();
		
		FileReader fr = new FileReader(fichero);
//		BufferedReader br = new BufferedReader(fr);
//		
//		String linea;
//		
//		while((linea = br.readLine()) != null) {
//			
//			System.out.println("br: " + linea);
//		}
		
		Scanner sc = new Scanner(fr);
		
		while (sc.hasNext()) {
			System.out.println("sc: " + sc.nextLine());
			
		}
		
	}

}
