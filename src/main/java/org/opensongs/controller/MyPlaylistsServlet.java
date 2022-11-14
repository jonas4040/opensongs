/*
 * package org.opensongs.controller;
 * 
 * import jakarta.servlet.http.HttpServlet; import java.io.IOException;
 * 
 * import org.opensongs.model.Usuario;
 * 
 * import jakarta.servlet.RequestDispatcher; import
 * jakarta.servlet.ServletException; import
 * jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 *//**
	 * Servlet implementation class MyPlaylistsServlet
	 *//*
		 * public class MyPlaylistsServlet extends HttpServlet { private static final
		 * long serialVersionUID = 1L;
		 * 
		 * protected void doGet(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { String paginaRetorno;
		 * Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
		 * 
		 * if(usuario == null) { paginaRetorno="/index.jsp"; }else {
		 * //request.getSession().setAttribute("Usuario", usuario);
		 * paginaRetorno="/myplaylists.jsp"; }
		 * 
		 * RequestDispatcher dispatcher =
		 * getServletContext().getRequestDispatcher(paginaRetorno);
		 * dispatcher.forward(request, response); }
		 * 
		 * }
		 */