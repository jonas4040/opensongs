package org.opensongs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.opensongs.model.Musica;
import org.opensongs.model.Playlist;
import org.opensongs.model.Usuario;

public class UsuarioDAO implements GenericDAO{
	private DataSource dataSource;
	
	public UsuarioDAO(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	@Override
	public void create(Object objeto) {}
	
	@Override
	public List<Object> read(Object objCriterio) {//faz algum select
		try {
			if(objCriterio instanceof Usuario) {
				Usuario incompleto = (Usuario) objCriterio;
				String query= "SELECT * FROM tblUsuario WHERE email = ? AND senha = ?";
				PreparedStatement stmQuery = dataSource.getConnection().prepareStatement(query);
				stmQuery.setString(1, incompleto.getEmail());
				stmQuery.setString(2, incompleto.getPass());
				ResultSet tabela = stmQuery.executeQuery();
				
				List<Object> usuariosList = new ArrayList<>();
				if(tabela.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(tabela.getInt("idUsuario")); 
					usuario.setNome(tabela.getString("nome"));
					usuario.setEmail(tabela.getString("email"));
					usuario.setPass(tabela.getString("senha"));
					usuariosList.add(usuario);
				}
				stmQuery.close();
				tabela.close();
				return usuariosList;
			}else {
				throw new RuntimeException("Instancia de objeto inválida, passe um usuário!");
			}
		}catch(SQLException e) {
			System.out.println("\n\tErro ao obter usuario -->"+e.getMessage());
		}
		return null;
	}
	
	@Override
	public void update(Object objeto) {}
	
	@Override
	public void delete(Object objeto) {}
}
