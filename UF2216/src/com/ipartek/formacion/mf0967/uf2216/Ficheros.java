package com.ipartek.formacion.mf0967.uf2216;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheros {

	public static void main(String[] args) {

//		String fichero = "C:\\trabajos\\nuevos";
//		String fichero = "C:/trabajos/nuevos";
//		
//		System.out.println(fichero);
		
		String fichero = "datos.txt";
		PrintWriter pw = null;
		try {
			
			FileWriter fw = new FileWriter(fichero);
			pw = new PrintWriter(fw);
			
			pw.println("Hola desde el nuevo fichero");
			
		} catch (IOException e) {			
			System.err.println("No se ha podido escribir el fichero");
			
		} finally {	
			if(pw != null) {
				pw.close();				
			}
		}
		
		
		try ( 	FileReader fr = new FileReader(fichero);
				Scanner sc = new Scanner(fr)) {
			
			while (sc.hasNext()) {
				System.out.println("sc: " + sc.nextLine());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
