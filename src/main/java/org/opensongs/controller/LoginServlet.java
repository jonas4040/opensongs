package org.opensongs.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import org.opensongs.dao.UsuarioDAO;

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
		String pagina;
		
		/* SImular Recuperação do BD */
		List<Object> resultado;
		UsuarioDAO userDAO = new UsuarioDAO();
		resultado = userDAO.read(null);
		
		if(email.equals("jonas@email.com") && pass.equals("1234")) {
			
			request.getSession().setAttribute("Usuario", resultado.get(0));
			
			pagina = "/myaccount.jsp";
		}else {
			request.setAttribute("erroSTR","O e-mail e / ou a senha não foram encontrados!");
			
			//vai para uma pagina de erro
			pagina = "/error.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);//redireciona para a pagina
		dispatcher.forward(request, response);
	}

}
