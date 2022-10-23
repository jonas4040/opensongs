package org.opensongs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import org.opensongs.dao.DataSource;
import org.opensongs.dao.PlaylistDAO;
import org.opensongs.model.Playlist;
import org.opensongs.model.Usuario;

/**
 * Servlet implementation class CreatePlaylistServlet
 */
public class CreatePlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino = "/index.jsp";
		try{
			Usuario user = (Usuario)request.getSession().getAttribute("Usuario");
			if(Objects.nonNull(user)) {
				String tituloPlaylist = request.getParameter("txtPlaylistName");
				Playlist playlist = new Playlist();
				playlist.setTitulo(tituloPlaylist);
				playlist.setUsuario(user);
				//TODO setId de musica
				
				//gravando no banco de dados
				DataSource dataSource = new DataSource();
				PlaylistDAO playlistDAO = new PlaylistDAO(dataSource);
				playlistDAO.create(playlist);
				dataSource.getConnection().close();
				
				if(Objects.isNull(user.getPlaylists())){
					user.setPlaylists(new ArrayList<Playlist>());
				}
				user.getPlaylists().add(playlist);
				request.getSession().setAttribute("Usuario", user);// porque modificou o usuario add playlist nova
				paginaDestino="/myplaylists.jsp";
			}
		}catch (Exception e) {
			paginaDestino = "/error.jsp";
			request.setAttribute("erroSTR", "Parece que algo deu errado, tente de novo mais tarde.");
			System.out.println("Erro ao cadastrar Playlist"+ e.getMessage());
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}

}
