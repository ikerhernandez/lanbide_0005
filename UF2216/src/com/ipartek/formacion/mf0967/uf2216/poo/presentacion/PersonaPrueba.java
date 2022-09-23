package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Persona;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Persona.Formato;

public class PersonaPrueba {

	public static void main(String[] args) {
		Persona.setFormato(Formato.MAYUSCULAS);
		
		Persona p;
		p = new Persona(null, "  Javier Lete  ", null);
		
//		Persona 1
		System.out.println("\nDatos Persona 1");
		System.out.println(p);
		System.out.println(p.getId());
		System.out.println(p.getNombre());
		
		p.setId(1L);
		p.setNombre("Javier");
		
//		Cambiar nombre de Persona 1
		System.out.println("\nCambiar nombre de Persona 1");
		System.out.println(p);
		System.out.println(p.getId());
		System.out.println(p.getNombre());
		
		Persona p2 = new Persona(p);
		
		p2.setNombre("Pepe");
		
//		MODIFICANDO
//		Datos Persona 1
		System.out.println("\nMODIFICANDO");
		System.out.println("Datos Persona 1");
		System.out.println(p);
		System.out.println(p.getId());
		System.out.println(p.getNombre());
		
//		Datos Persona 2
		System.out.println("\nDatos Persona 2");
		System.out.println(p2);
		System.out.println(p2.getId());
		System.out.println(p2.getNombre());
		
		System.out.println(p == p2); // Compraración de punteros (¿Son el mismo?)
		System.out.println(p.equals(p2)); // Comparación de contenido (¿Son iguales?)
		
		
		Persona p3 = new Persona(4L, "Antonio", "Banderas");
		
//		Datos Persona 3
		System.out.println("\nDatos Persona 3");
		System.out.println(p3);
		System.out.println(p3.getId());
		System.out.println(p3.getNombre());
		System.out.println(p3.getApellidos());
		
		System.out.println(p3.getNombreCompleto());
		
		
		Persona p4 = new Persona(4L, "Javier", "Lete");
		
//		Datos Persona 4
		System.out.println("\nDatos Persona 4");
		System.out.println(p4);
		System.out.println(p4.getId());
		System.out.println(p4.getNombreCompleto());
		System.out.println(p4.getInformacion());
		
		System.out.println();
		
		
		
		
	}
}
