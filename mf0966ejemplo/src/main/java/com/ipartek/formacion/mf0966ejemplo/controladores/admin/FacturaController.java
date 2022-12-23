package com.ipartek.formacion.mf0966ejemplo.controladores.admin;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;
import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/facturas")
public class FacturaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<Factura> facturas = Globales.DAO_FACTURA.obtenerTodos();
		
		request.setAttribute("facturas", facturas);		

		
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/facturas.jsp").forward(request, response);
	}

}
