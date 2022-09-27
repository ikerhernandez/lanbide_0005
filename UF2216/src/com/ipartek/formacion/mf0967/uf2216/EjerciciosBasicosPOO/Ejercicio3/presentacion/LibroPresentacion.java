package com.ipartek.formacion.mf0967.uf2216.EjerciciosBasicosPOO.Ejercicio3.presentacion;


import static com.ipartek.formacion.mf0967.uf2216.bibliotecas.Consola.*;
import com.ipartek.formacion.mf0967.uf2216.EjerciciosBasicosPOO.Ejercicio3.pojos.Libro;

public class LibroPresentacion {

//	Ejercicio 3 Crea una clase Libro con los métodos préstamo, devolución y toString. 
//	La clase contendrá un constructor por defecto, un constructor con parámetros 
//	y los métodos getters y setters.
	
	public static void main(String[] args) {
		
//      Se crea el objeto libro1 utilizando el constructor con parámetros
        Libro libro1 = new Libro("El quijote", "Cervantes", 1, 0);
        
//      Se crea el objeto libro2 utilizando el constructor por defecto
        Libro libro2 = new Libro();
        
//      Se piden los parametros
        String titulo = gString("Introduce titulo");
        String autor = gString("Introduce autor");
        int ejemplares = gInt("Numero de ejemplares");
        
//		Se asignan los parametros a libro2
        libro2.setTitulo(titulo);
        libro2.setAutor(autor);
        libro2.setEjemplares(ejemplares);
        
//		Se muestran los datos de libro1
        pl("\nLibro1");
        p("\nTitulo: ");
        pl(libro1.getTitulo());
        p("Autor: ");
        pl(libro1.getAutor());
        p("Ejemplares: ");
        pl(libro1.getEjemplares());
        p("Prestados: ");
        pl(libro1.getPrestados());
        
//		Se realiza un prestamo de libro1
        if(libro1.prestamo()) {
        	pl("\nSe ha prestado el libro: "+ libro1.getTitulo());
        }else {
        	pl("\nNo se ha podido prestar el libro: "+ libro1.getTitulo());
        }
        
//		Se realiza la devolucion de libro1
        if(libro1.devolucion()) {
        	pl("Se ha devuelto el libro: "+ libro1.getTitulo());
        }else {
        	pl("No se ha podido devolver el libro: "+ libro1.getTitulo());        	
        }
        
//		Se realiza otro prestamo de libro1
        if(libro1.prestamo()) {
        	pl("Se ha prestado el libro: "+ libro1.getTitulo());
        }else {
        	pl("No se ha podido prestar el libro: "+ libro1.getTitulo());
        }
        
//		Se realiza otro prestamo de libro1 pero no quedan ejemplares por lo que se mostrara por pantalla 'No se ha podido...'
        if(libro1.prestamo()) {
        	pl("Se ha prestado el libro: "+ libro1.getTitulo());
        }else {
        	pl("No se ha podido prestar el libro: "+ libro1.getTitulo());
        }																		
        
//		Se muestran los datos de libro1
        pl("\nLibro1");
        p("\nTitulo: ");
        pl(libro1.getTitulo());
        p("Autor: ");
        pl(libro1.getAutor());
        p("Ejemplares: ");
        pl(libro1.getEjemplares());
        p("Prestados: ");
        pl(libro1.getPrestados());
        
//		Se muestran los datos de libro2
        pl("\nLibro2");
        p("\nTitulo: ");
        pl(libro2.getTitulo());
        p("Autor: ");
        pl(libro2.getAutor());
        p("Ejemplares: ");
        pl(libro2.getEjemplares());
        p("Prestados: ");
        pl(libro2.getPrestados());
        
        
        
        
        
        
        
        
        
	}

}
