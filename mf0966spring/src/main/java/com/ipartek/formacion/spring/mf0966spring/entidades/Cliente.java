package com.ipartek.formacion.spring.mf0966spring.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String nif;
	private String email;

	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL, orphanRemoval = true)
	private final Set<Factura> facturas = new HashSet<>();

	public Cliente(Long id, String nombre, String nif, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nif = nif;
		this.email = email;
	}
	
	
}
