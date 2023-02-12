package org.opensongs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.opensongs.dao.DataSource;
import org.opensongs.dao.MusicaDAO;
import org.opensongs.model.Usuario;

/**
 * Servlet implementation class GetSongsServlet
 */
public class GetSongsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pgDestino = "/error.jsp";
		
		try {
			Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
			if(Objects.isNull(usuario)) {
				request.setAttribute("erroSTR", "Parece que você não está mais logado, volte e entre de novo!");
			}else {
				DataSource dataSource = new  DataSource();
				MusicaDAO musicaDAO = new MusicaDAO(dataSource);
				
				List<Object> listaMusicas = musicaDAO.read(null);
				if(Objects.isNull(listaMusicas)) {
					request.setAttribute("erroSTR", "Erro ao recuperar músicas do BD");
				}else {
					String idPlaylist = request.getParameter("playlist");//pega parametro da URL
					request.setAttribute("idPlaylist", idPlaylist);
					
					request.setAttribute("ListaMusicas", listaMusicas);
					pgDestino = "/mysongs.jsp";
				}
				dataSource.getConnection().close();
			}
		}catch (Exception e) {
			System.out.println("Erro ao montar página de músicas "+e.getMessage());
			request.setAttribute("erroSTR", "Erro ao montar página de músicas");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pgDestino);
		dispatcher.forward(request, response);
	}

}
