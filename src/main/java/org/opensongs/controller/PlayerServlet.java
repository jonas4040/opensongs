package org.opensongs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import org.opensongs.model.Playlist;
import org.opensongs.model.Usuario;

/**
 * Servlet implementation class PlayerServlet
 */
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pgDestino = "/error.jsp";
		Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");

		if (Objects.nonNull(usuario)) {
			Playlist playlist = (Playlist) request.getSession().getAttribute("Playlist");
			if (Objects.nonNull(playlist)) {
				pgDestino = "/player.jsp";
			}
		} else {
			request.setAttribute("erroSTR", "ERRO! voce esta deslogado!");
		}
		try {

		} catch (Exception e) {
		}
		RequestDispatcher dispatcher = 	getServletContext().getRequestDispatcher(pgDestino);
		dispatcher.forward(request, response);
	}

}
