package org.opensongs.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import org.opensongs.dao.DataSource;
import org.opensongs.dao.UsuarioDAO;
import org.opensongs.model.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet{
	//private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String pass = request.getParameter("txtSenha");
		Usuario incompleto = new Usuario();
		incompleto.setEmail(email);
		incompleto.setPass(pass);
		String pagina="/error.jsp";
		
		DataSource dataSource;
		try {
			dataSource = new DataSource();
			UsuarioDAO userDAO = new UsuarioDAO(dataSource);
			List<Object> resultado = userDAO.read(incompleto);
			
			if(resultado != null && resultado.size() > 0) {
				request.getSession().setAttribute("Usuario", resultado.get(0));
				pagina="/myaccount.jsp";
			}else {
				request.setAttribute("erroSTR","O e-mail e / ou a senha não foram encontrados!");
			}
			dataSource.getConnection().close();
		}catch(Exception e) {
			request.setAttribute("erroSTR","Erro ao recuperar usuário");
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);//redireciona para a pagina
		dispatcher.forward(request, response);
	}

}
