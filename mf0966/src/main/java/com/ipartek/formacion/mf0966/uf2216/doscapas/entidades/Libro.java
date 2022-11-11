package com.ipartek.formacion.mf0966.uf2216.doscapas.entidades;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

// Vamos a utilizarlo como Modelo en lugar de Entidad 
public class Libro {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Long descuento;

	private Map<String, String> errores = new TreeMap<>();

	public Libro(String id, String nombre, String precio, String descuento) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
	}

	public Libro(Long id, String nombre, BigDecimal precio, Long descuento) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
	}

	public Libro() {
	}

	public Long getId() {
		return id;
	}

	private void setId(String id) {
		if (id == null) {
			setId((Long) null);
		} else {
			if (id.trim().length() == 0) {
				setId((Long) null);
			} else {
				try {
					setId(Long.parseLong(id));
				} catch (NumberFormatException e) {
					errores.put("id", "El id debe ser numérico");
				}
			}
		}
	}

	public void setId(Long id) {
		if (id != null && id <= 0L) {
			errores.put("id", "El id debe ser mayor o igual que uno");
		}

		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 2) {
			errores.put("nombre", "El producto tiene que tener un nombre de 2 caracteres o más");
		}else if(nombre.trim().length() > 150) {
			errores.put("nombre", "El producto no puede tener más de 150 caracteres");
		}

		this.nombre = nombre.trim();
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	private void setPrecio(String precio) {
		try {
			setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			errores.put("precio", "El precio debe ser un número con decimales");
		}
	}

	public void setPrecio(BigDecimal precio) {
		if (precio == null || precio.compareTo(new BigDecimal("0.01")) < 0) {
			errores.put("precio", "El precio debe ser 0.01 o más");
		}

		this.precio = precio;
	}

	public Long getDescuento() {
		return descuento;
	}

	private void setDescuento(String descuento) {
		try {
			setDescuento(Long.parseLong(descuento));
		} catch (NumberFormatException e) {
			errores.put("descuento", "El descuento debe ser numérica y es obligatoria");
		}
	}

	public void setDescuento(Long descuento) {
		if (descuento == null || descuento < 0) {
			errores.put("descuento", "El descuento debe ser 0 o más");
		}else if(descuento > 100) {
			errores.put("descuento", "El descuento no puede ser 100 o más");
		}

		this.descuento = descuento;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descuento, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(descuento, other.descuento)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio
				+ ", descuento=" + descuento + "]";
	}
}
