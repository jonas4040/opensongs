package org.opensongs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import org.opensongs.dao.DataSource;
import org.opensongs.dao.PlaylistDAO;

/**
 * Servlet implementation class AddToPlaylistServlet
 */
public class AddToPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String pgResultado = "/result.jsp";
		DataSource dataSource = null;
		
		try {
			Integer idPlaylist = Integer.parseInt(request.getParameter("playlist"));
			Integer idMusica = Integer.parseInt(request.getParameter("song"));
			
			dataSource = new DataSource();
			PlaylistDAO playlistDAO = new PlaylistDAO(dataSource);
			if(playlistDAO.create(idPlaylist,idMusica)) {
				request.setAttribute("strRESULT", "SUCESSO!");
			}else {
				request.setAttribute("strRESULT", "ERRO DUPLICATA");
			}
			dataSource.getConnection().close();
			

		}//catch(RuntimeException e) {
			//System.out.println("Erro de duplicatas "+e.getMessage());
			//request.setAttribute("strRESULT", "DUPLICATA");
		//}
		catch(Exception e) {
			if(Objects.nonNull(dataSource)) {
				try {
					dataSource.getConnection().close();
				} catch (SQLException e1) {
					System.out.println("A conexão não foi fechada!");
				}
			}
			
			System.out.println("Erro ao inserir "+e.getMessage());
			request.setAttribute("strRESULT", "ERRO");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pgResultado);
		dispatcher.forward(request, response);
	}

}
