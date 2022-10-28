package com.ipartek.formacion.uf2218;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookies/escribir")
public class CookieEscribir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie c = new Cookie("colores", "oscuros");
		c.setMaxAge(Integer.MAX_VALUE);
		
		response.addCookie(c);
		
		response.getWriter().println("La cookie ha sido enviada");
	}


}
