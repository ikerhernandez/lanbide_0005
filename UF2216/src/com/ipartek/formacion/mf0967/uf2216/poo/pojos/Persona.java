package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

public class Persona {

	private Long id;
	private String nombre;
	
//	Constructor
	public Persona(Long id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	
	public Persona() { // Implícito si no hay otro constructor
		this(null, "ANÓNIMO");
	}


	//	Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id != null && id < 0) {
			throw new RuntimeException("No se admiten ids negativos");
		}
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new RuntimeException("No se admiten nombres nulos");
		}
		if(nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres nulos");			
		}
		
		this.nombre = nombre.trim();

	}
	
	
}
