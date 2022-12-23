package com.ipartek.formacion.mf0966ejemplo.controladores.admin;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;
import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)

@WebServlet("/admin/producto")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "imgs";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");

		if (id != null && !id.equals("")) {
			
			Producto producto = Globales.DAO_PRODUCTO.obtenerPorId(Long.parseLong(id));
			request.setAttribute("producto", producto);
		}

		Iterable<Categoria> categorias = Globales.DAO_CATEGORIA.obtenerTodos();

		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("/WEB-INF/vistas/admin/producto.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");

		if (id == null || id.equals("")) {
			String idcategoria = request.getParameter("categoria");
			Categoria categoria = Globales.DAO_CATEGORIA.obtenerPorId(Long.parseLong(idcategoria));
			String nombre = request.getParameter("nombre");
			String precio = request.getParameter("precio");
			String descripcion = request.getParameter("descripcion");

			Producto producto = new Producto(null, nombre, new BigDecimal(precio), descripcion,
					categoria);
			
			Globales.DAO_PRODUCTO.insertar(producto);
			producto = Globales.DAO_PRODUCTO.obtenerUltimo();
			id = producto.getId()+"";
		} else {
			String idcategoria = request.getParameter("categoria");
			Categoria categoria = Globales.DAO_CATEGORIA.obtenerPorId(Long.parseLong(idcategoria));
			String nombre = request.getParameter("nombre");
			String precio = request.getParameter("precio");
			String descripcion = request.getParameter("descripcion");

			Producto producto = new Producto(Long.parseLong(id), nombre, new BigDecimal(precio), descripcion,
					categoria);
			
			Globales.DAO_PRODUCTO.modificar(producto);
		}
		
		
		// ESPECÍFICO FILE UPLOAD
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();

		String fileName;
		
		for (Part part : request.getParts()) {
		    fileName = part.getSubmittedFileName();
			
		    if(fileName != null) {
				part.write(uploadPath + File.separator + id + ".jpg");
			}
		}
		
		
		Iterable<Categoria> categorias = Globales.DAO_CATEGORIA.obtenerTodos();

		request.setAttribute("categorias", categorias);
		
		response.sendRedirect(request.getContextPath() + "/admin/index");
	}

}
