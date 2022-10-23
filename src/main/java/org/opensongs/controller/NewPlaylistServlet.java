package org.opensongs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import org.opensongs.model.Usuario;

/**
 * Servlet implementation class NewPlaylistServlet
 */
public class NewPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = (Usuario)request.getSession().getAttribute("Usuario");
		String paginaDestino = "/index.jsp";
		if(Objects.nonNull(user)) {
			paginaDestino="/newplaylist.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}

}
