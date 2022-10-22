package org.opensongs.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

import org.opensongs.dao.DataSource;
import org.opensongs.dao.UsuarioDAO;
import org.opensongs.model.Usuario;

public class CreateUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		try {
			String pagina = "/myaccount.jsp";
			String nome = request.getParameter("txtNome");
			String email = request.getParameter("txtEmail");
			String pass = request.getParameter("txtSenha");
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setPass(pass);
			
			//database
			DataSource dataSource = new DataSource();
			UsuarioDAO usuarioDAO = new UsuarioDAO(dataSource);
			usuarioDAO.create(usuario);
			//System.out.println(usuario);
			try {
				dataSource.getConnection().close();
			} catch (SQLException sqlEx) {
				System.out.println("\n\t\tErro ao fechar conexão--> "+sqlEx.getMessage());
				request.setAttribute("erroMSG", "não foi possível criar uma nova conta de usuário");
				pagina="/error.jsp";
				//sqlEx.printStackTrace();
			}
			if(usuario.getId()!=0) request.getSession().setAttribute("Usuario", usuario);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("\n\tErro --> "+e.getMessage());
		}
	}
}
