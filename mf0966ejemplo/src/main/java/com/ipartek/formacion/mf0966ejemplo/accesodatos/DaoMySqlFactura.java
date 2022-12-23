package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Cliente;
import com.ipartek.formacion.mf0966ejemplo.modelos.Empleado;
import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;
import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido.Linea;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

public class DaoMySqlFactura implements Dao<Factura> {

	private static final String SQL_SELECT = "SELECT f.id as id_factura, f.codigo, f.fecha, \r\n"
			+ "e.id as id_empleado, e.nombre as nombre_empleado, e.nif as nif_empleado, e.jefe_id,\r\n"
			+ "c.id as id_cliente, c.nombre as nombre_cliente, c.nif as nif_cliente, c.email\r\n"
			+ "FROM facturas_has_productos fp\r\n"
			+ "inner join facturas f\r\n"
			+ "	on f.id=fp.facturas_id\r\n"
			+ "inner join empleados e\r\n"
			+ "	on f.empleados_id=e.id\r\n"
			+ "inner join clientes c \r\n"
			+ "	on f.clientes_id=c.id\r\n"
			+ "group by fp.facturas_id;";
	
	private static final String SQL_SELECT_BY_CLIENTE = "SELECT f.id as id_factura, f.codigo, f.fecha, \r\n"
			+ "e.id as id_empleado, e.nombre as nombre_empleado, e.nif as nif_empleado, e.jefe_id,\r\n"
			+ "c.id as id_cliente, c.nombre as nombre_cliente, c.nif as nif_cliente, c.email\r\n"
			+ "FROM facturas_has_productos fp\r\n"
			+ "inner join facturas f\r\n"
			+ "	on f.id=fp.facturas_id\r\n"
			+ "inner join empleados e\r\n"
			+ "	on f.empleados_id=e.id\r\n"
			+ "inner join clientes c \r\n"
			+ "	on f.clientes_id=c.id where c.id=?\r\n"
			+ "group by fp.facturas_id;";
	
	private static final String SQL_PRODUCTOS = "SELECT\r\n"
			+ "fp.*,\r\n"
			+ "p.id,\r\n"
			+ "p.nombre,\r\n"
			+ "p.precio,\r\n"
			+ "p.descripcion,\r\n"
			+ "c.id, c.nombre,\r\n"
			+ "c.descripcion\r\n"
			+ "FROM facturas_has_productos fp\r\n"
			+ "join productos p\r\n"
			+ "on fp.productos_id=p.id\r\n"
			+ "join categorias c\r\n"
			+ "on p.categorias_id=c.id\r\n"
			+ "where fp.facturas_id=?;";
	
	private static final String SQL_INSERTAR = "INSERT INTO facturas (id, codigo, fecha, clientes_id, empleados_id) VALUES (null,?,?,?,?)";

	private static final String SQL_INSERTAR_LINEA = "INSERT INTO facturas_has_productos (facturas_id, productos_id, cantidad) VALUES (?,?,?);";

	private static final String SQL_NUEVO_CODIGO = "call nuevo_codigo(?)";
	
	// SINGLETON
	private DaoMySqlFactura() {
	}

	private static final DaoMySqlFactura INSTANCIA = new DaoMySqlFactura();

	public static DaoMySqlFactura getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	
	
	@Override
	public synchronized Factura insertar(Factura factura) {
		try (Connection con = getConexion()) {
			factura.setFecha(LocalDate.now());
			factura.setCodigo(nuevoCodigoFactura(con, factura));
			
			return insertarImpl(factura, con);
		} catch(Exception e) {
			throw new AccesoDatosException("No se ha podido insertar la factura", e);
		}
	}
	
	@Override
	public Iterable<Factura> obtenerTodos() { //--------------------------------OBTENER TODAS LAS FACTURAS
		List<Factura> facturas = new ArrayList<>();

		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT)) {
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
					Set<Linea> lineas = new HashSet<>();
				
					Long id = rs.getLong("id_factura"); 
					
					lineas = obtenerProductos(id);
					
					facturas.add(new Factura(rs.getLong("id_factura"), rs.getString("codigo"), rs.getDate("fecha").toLocalDate(), new Cliente(rs.getLong("id_cliente"), rs.getString("nombre_cliente"), rs.getString("nif_cliente"), rs.getString("email")), new Empleado(rs.getLong("id_empleado"), rs.getString("nombre_empleado"), rs.getString("nif_empleado"), new Empleado()), lineas));
			}
			
			return facturas;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
	
	@Override
	public Iterable<Factura> obtenerFacturas(Long id) { //---------------------------------OBTENER FACTURAS POR CLIENTE
		List<Factura> facturas = new ArrayList<>();

		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_BY_CLIENTE)) {
			
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
					Set<Linea> lineas = new HashSet<>();

					lineas = obtenerProductos(rs.getLong("id_factura"));
					
					facturas.add(new Factura(rs.getLong("id_factura"), rs.getString("codigo"), rs.getDate("fecha").toLocalDate(), new Cliente(rs.getLong("id_cliente"), rs.getString("nombre_cliente"), rs.getString("nif_cliente"), rs.getString("email")), new Empleado(rs.getLong("id_empleado"), rs.getString("nombre_empleado"), rs.getString("nif_empleado"), new Empleado()), lineas));
			}
			
			return facturas;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
	
	private String nuevoCodigoFactura(Connection con, Factura factura) {
		try (CallableStatement cst = con.prepareCall(SQL_NUEVO_CODIGO)) {
			cst.setString(1, String.valueOf(factura.getFecha().getYear()));
			
			ResultSet rs = cst.executeQuery();
			
			rs.next();
			
			return rs.getString(1);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir el nuevo código", e);
		}
	}
	
	@Override
	public Set<Linea> obtenerProductos(Long id) { //-----------------------------------OBTENER PRODUCTOR DE FACTURA
		Set<Linea> lineas = new HashSet<>();
		
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_PRODUCTOS)) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				lineas.add(new Linea(
						null,new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"), rs.getString("p.descripcion"), new Categoria(rs.getLong("c.id"),rs.getString("c.nombre"),rs.getString("c.descripcion"))), 
						rs.getInt("cantidad")
						));	
			}
			return lineas;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
	
	@Override
	public Factura insertarImpl(Factura factura, Connection con) {
		try (PreparedStatement pst = con.prepareStatement(SQL_INSERTAR, Statement.RETURN_GENERATED_KEYS)) {
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			pst.setString(1, factura.getCodigo());
			pst.setDate(2, java.sql.Date.valueOf(factura.getFecha()));
			pst.setLong(3, factura.getCliente().getId());
			pst.setLong(4, factura.getEmpleado().getId());
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();

			rs.next();

			factura.setId(rs.getLong(1));

			insertarLineasImpl(factura, con);
			
			con.commit();
			
			return factura;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar la factura", e);
		}
		
	}
	
	private void insertarLineasImpl(Factura factura, Connection con) throws SQLException {
		try (PreparedStatement pstLinea = con.prepareStatement(SQL_INSERTAR_LINEA)) {
			pstLinea.setLong(1, factura.getId());

			for (Linea linea : factura.getLineas()) {
				pstLinea.setLong(2, linea.getProducto().getId());
				pstLinea.setInt(3, linea.getCantidad());

				pstLinea.executeUpdate();
			}
		}
	}

}
