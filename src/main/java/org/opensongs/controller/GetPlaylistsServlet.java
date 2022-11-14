package org.opensongs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.opensongs.dao.DataSource;
import org.opensongs.dao.PlaylistDAO;
import org.opensongs.model.Playlist;
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
					DataSource dataSource = new DataSource();
					PlaylistDAO playlistDAO = new PlaylistDAO(dataSource);
					List<Object> lista = playlistDAO.read(usuario.getId());
					dataSource.getConnection().close();
					System.out.println("Recuperado com sucesso!");
					
					if(Objects.nonNull(lista)) {
						List<Playlist> playlists = new ArrayList<>();
						Iterator<Object> it = lista.iterator();
						while(it.hasNext()) {							
							Playlist playlist = (Playlist)it.next();
							playlist.setUsuario(usuario);
							playlists.add(playlist);
						}
						usuario.setPlaylists(playlists);
					}
				}
				request.getSession().setAttribute("Usuario", usuario);
				pgDestino = "/myplaylists.jsp";
				/**
				 * @param pgDestino não entra no servlet
				 */
			}
		}catch(Exception e) {
			System.out.println("Erro ao recuperar playlists "+e.getMessage());
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pgDestino);
		dispatcher.forward(request, response);
	}

}
