package org.opensongs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.opensongs.dao.DataSource;
import org.opensongs.dao.PlaylistDAO;
import org.opensongs.model.Musica;
import org.opensongs.model.Playlist;

/**
 * Servlet implementation class PlaylistDetailsServlet
 */
public class PlaylistDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pgDestino = "/error.jsp";
		if(Objects.nonNull(req.getSession().getAttribute("Usuario"))) {
			try {
				DataSource dataSource = new DataSource();
				PlaylistDAO playlistDAO = new PlaylistDAO(dataSource);
				
				Integer idPlaylist = Integer.parseInt(req.getParameter("id"));
				Playlist playlist = playlistDAO.readDetailsById(idPlaylist);
		
				if(Objects.nonNull(playlist)) {
					req.setAttribute("Playlist", playlist);
					pgDestino = "/playlistdetails.jsp";
				}else {
					req.setAttribute("erroSTR", " não foi possível recuperar  a Playlist");
				}
			}catch(Exception e) {
				req.setAttribute("erroSTR","Ocorreu um erro inesperado, contate a equipe de suporte!");
			}
		}else {
			req.setAttribute("erroSTR","Você não está logado, entre novamente!");
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pgDestino);
		requestDispatcher.forward(req, resp);
	}

}
