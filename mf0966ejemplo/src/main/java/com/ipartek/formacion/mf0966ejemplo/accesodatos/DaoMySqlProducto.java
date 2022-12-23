package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

public class DaoMySqlProducto implements Dao<Producto> {

	private static final String SQL_SELECT = "SELECT \r\n"
			+ "p.id, \r\n"
			+ "p.nombre, \r\n"
			+ "p.precio, \r\n"
			+ "p.descripcion, \r\n"
			+ "c.id, c.nombre, \r\n"
			+ "c.descripcion \r\n"
			+ "FROM productos p \r\n"
			+ "join categorias c \r\n"
			+ "on p.categorias_id=c.id ORDER BY p.id";
	
	private static final String SQL_SELECT_ID = "SELECT \n"
			+ "    p.id,\n"
			+ "    p.nombre,\n"
			+ "    p.precio,\n"
			+ "    p.descripcion,\n"
			+ "    c.id,\n"
			+ "    c.nombre,\n"
			+ "    c.descripcion\n"
			+ "FROM\n"
			+ "    productos p\n"
			+ "        JOIN\n"
			+ "    categorias c ON p.categorias_id = c.id\n"
			+ "WHERE\n"
			+ "    p.id = ?";
	
	private static final String SQL_SELECT_LAST = "SELECT \n"
			+ "    p.id,\n"
			+ "    p.nombre,\n"
			+ "    p.precio,\n"
			+ "    p.descripcion,\n"
			+ "    c.id,\n"
			+ "    c.nombre,\n"
			+ "    c.descripcion\n"
			+ "FROM\n"
			+ "    productos p\n"
			+ "        JOIN\n"
			+ "    categorias c ON p.categorias_id = c.id\n"
			+ "ORDER BY p.id DESC LIMIT 1";
	
	private static final String SQL_INSERTAR = "INSERT INTO productos\r\n"
			+ "(`id`,\r\n"
			+ "`nombre`,\r\n"
			+ "`precio`,\r\n"
			+ "`descripcion`,\r\n"
			+ "`categorias_id`)\r\n"
			+ "VALUES\r\n"
			+ "(null,?,?,?,?);";
	
	private static final String SQL_MODIFICAR = "UPDATE productos\r\n"
			+ "SET\r\n"
			+ "`nombre` = ?,\r\n"
			+ "`precio` = ?,\r\n"
			+ "`descripcion` = ?,\r\n"
			+ "`categorias_id` = ? \r\n"
			+ "WHERE `id` = ?;";
	
	private static final String SQL_BORRAR = "DELETE FROM `productos`\r\n"
			+ "WHERE id=?;";
	
	// SINGLETON
	private DaoMySqlProducto() {
	}

	private static final DaoMySqlProducto INSTANCIA = new DaoMySqlProducto();

	public static DaoMySqlProducto getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Producto> obtenerTodos() {
		List<Producto> productos = new ArrayList<>();
		
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT)) {
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Categoria categoria = new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.descripcion"));
				productos.add(new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"), rs.getString("p.descripcion"), categoria));
			}
			
			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
	
	@Override
	public Producto obtenerPorId(Long id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Producto producto = null;
			
			if(rs.next()) {
				Categoria categoria = new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.descripcion"));
				producto = new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"), rs.getString("p.descripcion"), categoria);
			}
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
	
	@Override
	public Producto obtenerUltimo() {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_LAST)) {
			
			ResultSet rs = pst.executeQuery();
			
			Producto producto = null;
			
			if(rs.next()) {
				Categoria categoria = new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.descripcion"));
				producto = new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"), rs.getString("p.descripcion"), categoria);
			}
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
	
	@Override
	public Producto insertar(Producto producto) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERTAR)) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getDescripcion());
			pst.setLong(4, producto.getCategoria().getId());
			
			pst.executeUpdate();

			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el producto", e);
		}
		return producto;
	}
	
	@Override
	public Producto modificar(Producto producto) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_MODIFICAR)) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getDescripcion());
			pst.setLong(4, producto.getCategoria().getId());
			pst.setLong(5, producto.getId());
			
			pst.executeUpdate();

			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el producto", e);
		}
		return producto;
	}
	
	@Override
	public void borrar(Long id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_BORRAR)) {
			pst.setLong(1, id);
			
			pst.executeUpdate();

			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el producto", e);
		}
	}
	
	
}
