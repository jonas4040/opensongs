package org.opensongs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Servlet implementation class NewSongServlet
 */
public class NewSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pgDestino = "/error.jsp";
		if(Objects.nonNull(request.getSession().getAttribute("Usuario"))) {
			pgDestino="/newsong.jsp";
		}else {
			request.setAttribute("erroSTR", "Usuário não conectado, volte e entre com a sua conta!");
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pgDestino);
		requestDispatcher.forward(request, response);
		
	}

}
