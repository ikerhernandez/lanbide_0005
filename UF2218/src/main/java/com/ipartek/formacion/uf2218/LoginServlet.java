package com.ipartek.formacion.uf2218;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		if(validarUsuario(user, pass)) {
			request.getSession().setAttribute("usuario", user);
			response.sendRedirect("/UF2218mio/principal");
		} else {
			//response.sendRedirect("login.jsp");
			request.setAttribute("error", "El usuario o la contraseña son incorrectos");
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}
	}

	private boolean validarUsuario(String user, String pass) {
		return "javier".equals(user) && "lete".equals(pass);
	}
}
