package com.ipartek.formacion.mf0966.uf2218.controladores.admin;

import static com.ipartek.formacion.mf0966.uf2218.controladores.Globales.dao;

import java.io.IOException;

import com.ipartek.formacion.mf0966.uf2216.doscapas.entidades.Libro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/libro")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String descuento = request.getParameter("descuento");

		Libro libro = new Libro(id, nombre, precio, descuento);

		if (libro.getErrores().size() > 0) {
			request.setAttribute("alertaNivel", "danger");
			request.setAttribute("alertaMensaje", "Hay errores en el formulario");
			request.setAttribute("libro", libro);
			request.getRequestDispatcher("/WEB-INF/vistas/admin/libro.jsp").forward(request, response);
		} else {
			if (libro.getId() == null) {
				dao.insertar(libro);
			} else {
				dao.modificar(libro);
			}
			
			response.sendRedirect(request.getContextPath() + "/admin/index");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			Libro libro = dao.obtenerPorId(Long.parseLong(id));

			request.setAttribute("libro", libro);
		}

		request.getRequestDispatcher("/WEB-INF/vistas/admin/libro.jsp").forward(request, response);
	}

}
