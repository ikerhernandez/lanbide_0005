package com.ipartek.formacion.mf0966ejemplo.controladores;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/facturas")
public class FacturaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if(request.getParameter("id")!=null) {
			String id = request.getParameter("id");
			Iterable<Factura> facturasByCliente = Globales.DAO_FACTURA.obtenerFacturas(Long.parseLong(id));
			
			
			
			request.setAttribute("facturas", facturasByCliente);	
			request.getRequestDispatcher("/WEB-INF/vistas/facturas.jsp").forward(request, response);
		}
		
		
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

}
