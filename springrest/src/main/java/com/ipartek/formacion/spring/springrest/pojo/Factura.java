package com.ipartek.formacion.spring.springrest.pojo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "fecha")
	private LocalDate fecha;

	@ManyToOne
	@JoinColumn(name = "clientes_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "empleados_id")
	private Empleado empleado;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	    name = "facturas_has_productos", 
	    joinColumns = { @JoinColumn(name = "facturas_id") }, 
	    inverseJoinColumns = { @JoinColumn(name = "productos_id") }
	)
	Set<Producto> productos = new HashSet<>();
}