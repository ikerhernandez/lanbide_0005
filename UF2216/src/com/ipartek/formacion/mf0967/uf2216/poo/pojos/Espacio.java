package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

import java.util.ArrayList;
import java.util.List;

public class Espacio {

	private Long id;
	private String nombre;

	private List<Persona> personas = new ArrayList<>();

	
//	Contructores
	public Espacio(Long id, String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public Espacio(String nombre) {
		this(null, nombre);
	}

//	Getters && Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		if(nombre == null) {
			throw new RuntimeException("No se admiten nombres nulos");
		}
		if(nombre.trim().length() < 0) {
			throw new RuntimeException("No se admiten nombres con menos de 3 caracteres");			
		}
	}
	
	public void entrar(Persona persona) {
		personas.add(persona);
	}
	
	public void salir(Persona persona) {
		personas.remove(persona);
	}
	
	
	public Persona[] getPersonas(){
		return personas.toArray(new Persona[personas.size()]);
	}
	
	
	
	
	
	

}
