package com.ipartek.formacion.mf0966.uf2216.doscapas.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.mf0966.uf2216.doscapas.entidades.Libro;

public class DaoMySqlLibro implements Dao<Libro> {

	private static final String URL = "jdbc:mysql://localhost:3306/mf0966";
	private static final String USER = "mf0966";
	private static final String PASSWORD = "mf0966";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

//	SENTENCIAS SQL
	private static final String SQL_SELECT = "SELECT * FROM libros";
	private static final String SQL_SELECT_ID = "SELECT * FROM libros WHERE id= ?";
	private static final String SQL_INSERT = "INSERT INTO `libros` (`id`, `nombre`, `precio`, `descuento`) VALUES (null,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE `libros` SET `nombre` = ?, `precio` = ?, `descuento` = ? WHERE `id` = ?";
	private static final String SQL_DELETE = "DELETE FROM `libros` WHERE id= ?";

	private static final DaoMySqlLibro INSTANCIA = new DaoMySqlLibro();

	public static DaoMySqlLibro getInstancia() {
		return INSTANCIA;
	}

//	METODO para obtener todos los libros
	@Override
	public Iterable<Libro> obtenerTodos() {
		
		List<Libro> listalibros = new ArrayList<Libro>();

		try {
			Class.forName(DRIVER);
			
			try {
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs;
				rs = pst.executeQuery();
				
				while (rs.next()) {
					Libro l = new Libro();
					
					l.setId(rs.getLong("id"));
					l.setNombre(rs.getString("nombre"));
					l.setPrecio(rs.getBigDecimal("precio"));
					l.setDescuento(rs.getLong("descuento"));
					listalibros.add(l);
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		
		return listalibros;
	}

//	METODO para obtener el libro por id
	@Override
	public Libro obtenerPorId(Long id) {
		
		Libro l = new Libro();

		try {
			Class.forName(DRIVER);
						
			try {
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				ResultSet rs;
				
				pst.setLong(1, id);
				
				rs = pst.executeQuery();
				
				if (rs.next()) {
					
					l.setId(rs.getLong("id"));
					l.setNombre(rs.getString("nombre"));
					l.setPrecio(rs.getBigDecimal("precio"));
					l.setDescuento(rs.getLong("descuento"));
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}

		return l;
	}

//	METODO para insertar libro
	@Override
	public Libro insertar(Libro libro) {

		try {
			Class.forName(DRIVER);
			
			try {
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);
				
				pst.setString(1, libro.getNombre());
				pst.setBigDecimal(2, libro.getPrecio());
				pst.setLong(3, libro.getDescuento());
				
				pst.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}

		return libro;
	}

//	METODO para modificar libro
	@Override
	public Libro modificar(Libro libro) {
		
		try {
			Class.forName(DRIVER);
			
			try {
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
				
				pst.setString(1, libro.getNombre());
				pst.setBigDecimal(2, libro.getPrecio());
				pst.setLong(3, libro.getDescuento());
				pst.setLong(4, libro.getId());
				
				pst.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}

		return libro;
	}

//	METODO para borrar libro
	@Override
	public void borrar(Long id) {
		
		try {
			Class.forName(DRIVER);
			
			try {
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				
				pst.setLong(1, id);
				
				pst.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
	}

}