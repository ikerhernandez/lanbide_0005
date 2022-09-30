package com.ipartek.formacion.mf0967.uf2216.Enlaces.EjerciciosPOO.EjerciciosBasicosPOO.Ejercicio3.pojos;

public class Libro {

//				VARIABLES
	////////////////////////////////////////
	
	private String titulo;
	private String autor;
	private int ejemplares;
	private int prestados;
	
//				CONSTRUCTORES
	////////////////////////////////////////
	
//	Constructor por defecto
	public Libro() {
		
	}
	
//	Constructor con parametros
	public Libro(String titulo, String autor, int ejemplares, int prestados) {
		setTitulo(titulo);
		setAutor(autor);
		setEjemplares(ejemplares);
		setPrestados(prestados);
	}

//			GETTER && SETTER
	////////////////////////////////////////

//	Titulo
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

//	Autor
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

//	Numero Ejemplares
	public int getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

//	Ejemplares Prestados
	public int getPrestados() {
		return prestados;
	}

	public void setPrestados(int prestados) {
		this.prestados = prestados;
	}
	
//				METODOS
	////////////////////////////////////////
	
//	Metodo Prestamo
	public boolean prestamo() {
		boolean prestamo = true;
		
		if(ejemplares > prestados) {
			prestados++;
			ejemplares--;
		}else {
			prestamo = false;
		}
		return prestamo;
	}
	
//	Metodo Devolucion
	public boolean devolucion() {
		boolean devolucion = true;
		
		if(prestados == 0) {
			devolucion = false;			
		}else {
			prestados--;
			ejemplares++;
		}
		return devolucion;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + 
				", ejemplares=" + ejemplares + ", prestados=" + prestados + "]";
	}
	
}
