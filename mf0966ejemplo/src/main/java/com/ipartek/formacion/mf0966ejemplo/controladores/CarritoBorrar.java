package com.ipartek.formacion.mf0966ejemplo.controladores;

import java.io.IOException;
import java.util.ConcurrentModificationException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido;
import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido.Linea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/carrito/borrar")
public class CarritoBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Pedido pedido = (Pedido) session.getAttribute("carrito");

		String id = request.getParameter("id");

		int cantidad= 1;
		
		try {
			if(pedido!=null) {
				
				for (Linea lista : pedido.getLineas()) {
					
					
					if(lista.getProducto().getId()==Long.parseLong(id) && lista.getCantidad() >= 1) {
						
							cantidad=lista.getCantidad()-1;
							lista.setCantidad(cantidad);
							
							if(lista.getCantidad()==0) {
								
								pedido.eliminar(lista.getProducto());
							}
						
					}
				}
			}
		} catch (ConcurrentModificationException e) {
			e.printStackTrace();
		}
		

		int total = 0;
		for (Linea l : pedido.getLineas()) {
			total += l.getCantidad();
		}

		request.getSession().setAttribute("cantidadcarrito", total);
		
		response.sendRedirect(request.getContextPath() + "/carrito");
	}
}
