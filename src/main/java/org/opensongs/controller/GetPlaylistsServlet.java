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
 * Servlet implementation class GetPlaylistsServlet
 */
public class GetPlaylistsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pgDestino = "/index.jsp";
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
			if(Objects.nonNull(usuario)) {
				if(Objects.isNull(usuario.getPlaylists())) {
					//TODO parei aqui minuto 54:00 do tutorial
				}
			}
		}catch(Exception e) {
			System.out.println("Erro ao recuperar playlists "+e.getMessage());
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pgDestino);
		dispatcher.forward(request, response);
	}

}
