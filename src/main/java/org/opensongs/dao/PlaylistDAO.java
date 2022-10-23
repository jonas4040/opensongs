package org.opensongs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.opensongs.model.Playlist;


public class PlaylistDAO implements GenericDAO{
	private DataSource dataSource;
	
	
	
	public PlaylistDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Object objeto) {
		try {
			Playlist playlist = (Playlist)objeto;
			String query="INSERT INTO tblPlaylist VALUES(null,?,?)";
			PreparedStatement statement = dataSource.getConnection().
					prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				statement.setString(1,playlist.getTitulo());
				statement.setInt(2, playlist.getUsuario().getId());
				
				Integer res = statement.executeUpdate();
				if(res==0) {
					throw new RuntimeException("Não foi possível incluir playlist");
				}
				ResultSet resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					playlist.setId(resultSet.getInt(1));
				}
		}catch(SQLException e) {
			System.out.println("Erro ao criar playlist no BD\n\t"+e.getMessage());
		}
	}

	@Override
	public List<Object> read(Object objCriterio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object objeto) {
		// TODO Auto-generated method stub
		
	}

}
