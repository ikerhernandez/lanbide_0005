package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

public class Persona {

//	Enumeracion
	public static enum Formato {
		SIN_FORMATO, MAYUSCULAS, MINUSCULAS
	}

//	Constantes
	private static final String NOMBRE_POR_DEFECTO = "ANÓNIMO";

//	Variables estáticas
	public static Formato formato = Formato.SIN_FORMATO;

//	Variables de instancia (Privadas)
	private Long id;
	private String nombre;
	private String apellidos;

//	Constructor
	public Persona(Long id, String nombre, String apellidos) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
	}

//	public Persona(Long id, String nombre, String apellidos) {
//	this.id = id;
//	this.nombre = nombre;
//	this.apellidos = apellidos;
//	}

	public Persona(Persona p) { // Implícito si no hay otro constructor
		this(p.getId(), p.getNombre(), p.getApellidos());
	}
	
	public Persona(Long id, String nombre) {
		this(id, nombre, null);
	}

	public Persona(String nombre) {
		this(null, nombre, null);
	}
	
	public Persona() { // Implícito si no hay otro constructor
		this(null, NOMBRE_POR_DEFECTO, null);
	}


	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id < 0) {
			throw new RuntimeException("No se admiten ids negativos");
		}
		this.id = id;
	}

	private static String formatear(String dato) {
		if (dato == null)
			return null;

		return dato;
	}

	public String getNombre() {
		return formatear(nombre);
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new RuntimeException("No se admiten nombres nulos");
		}
		if (nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres nulos");
		}

		this.nombre = nombre.trim();
	}

	public String getApellidos() {
		return formatear(apellidos);
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public static Formato getFormato() {
		return formato;
	}

	public static void setFormato(Formato formato) {
		Persona.formato = formato;
	}

//	Metodos de instancia

	public String getNombreCompleto() {
		return getNombre() + " " + getApellidos();
	}
	
	public String getInformacion() {
		return getId() + ": " + getNombre() + ", " + getApellidos();
	}


}
