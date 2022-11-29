package org.opensongs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import org.opensongs.dao.DataSource;
import org.opensongs.dao.MusicaDAO;
import org.opensongs.model.Musica;

/**
 * Servlet implementation class UploadSongServlet
 */
public class UploadSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pgDestino = "/error.jsp";
		if(Objects.nonNull(request.getSession().getAttribute("Usuario"))) {
			try {
				String songName = request.getParameter("txtSongName");
				String artista = request.getParameter("txtArtista");
				String album = request.getParameter("txtAlbum");
				Integer estilo = Integer.parseInt(request.getParameter("swtEstilo"));
				
				InputStream originalFile = request.getPart("fileMP3").getInputStream();
				String linkMP3 = request.getPart("fileMP3").getSubmittedFileName();
				String fileName = "/home/jonas/git/opensongs/src/main/webapp"+ //put this to deploy: getServletContext().getContextPath()
						"/musicas/"+
						request.getPart("fileMP3").getSubmittedFileName();
				FileOutputStream mp3File = new FileOutputStream(fileName);
				
                //System.out.println("Nome do arquivo "+fileName);
				
				byte b[] = new byte[1024];
				while(originalFile.available()>0) {
					originalFile.read(b);
					mp3File.write(b);
				}
				
				originalFile.close();
				mp3File.close();
				
				Musica musica = new Musica();
				musica.setAlbum(album);
				musica.setEstilo(estilo);
				musica.setArtista(artista);
				musica.setTitulo(songName);
				musica.setLinkMP3("musicas/"+linkMP3);
				
				DataSource dataSource = new DataSource();
				MusicaDAO musicaDAO = new MusicaDAO(dataSource);
				musicaDAO.create(musica);
				dataSource.getConnection().close();
				
				pgDestino="/myaccount.jsp";
			}catch(Exception e) {
				request.setAttribute("erroSTR", "Upload falhou!");
				e.printStackTrace();
			}
		}else {
			request.setAttribute("erroSTR", "Usuário não conectado, volte e entre com a sua conta!");
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pgDestino);
		requestDispatcher.forward(request, response);
	}

}
