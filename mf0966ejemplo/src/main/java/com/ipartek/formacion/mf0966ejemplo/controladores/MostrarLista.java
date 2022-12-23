package com.ipartek.formacion.mf0966ejemplo.controladores;

import java.io.IOException;
import java.util.Set;

import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido.Linea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/mostrarlista")
public class MostrarLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Set<Linea> linea = Globales.DAO_FACTURA.obtenerProductos(Long.parseLong(request.getParameter("id")));
		
		double totalproducto = 0;
		double total = 0;
		
		for (Linea obj : linea) {
			
			double precio=Double.parseDouble(obj.getProducto().getPrecio()+"");
			int cantidad=obj.getCantidad();
			totalproducto=precio*cantidad;
			total=totalproducto+total;
		}
		
		request.setAttribute("total", total);
		request.setAttribute("productos", linea);

		request.getRequestDispatcher("/WEB-INF/vistas/admin/mostrarlista.jsp").forward(request, response);
	}

}
