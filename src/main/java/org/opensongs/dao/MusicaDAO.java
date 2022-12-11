package org.opensongs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.opensongs.model.Musica;

public class MusicaDAO implements GenericDAO{
	private DataSource dataSource;

	public MusicaDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Object objeto) {
		try {
			if(objeto instanceof Musica) {
				Musica musica = (Musica) objeto;
				String query="INSERT INTO tblMusica VALUES(null,?,?,?,?,?)";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(query);
				stm.setString(1, musica.getTitulo());
				stm.setString(2, musica.getArtista());
				stm.setString(3, musica.getAlbum());
				stm.setInt(4, musica.getEstilo());
				stm.setString(5, musica.getLinkMP3());
				stm.executeUpdate();
				stm.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Object> read(Object objCriterio) {
		try {
			String query = "SELECT * FROM tblMusica ORDER BY titulo";
			PreparedStatement stm = dataSource.getConnection().prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			
			List<Object> listaMusicas = new ArrayList<>();
			while(rs.next()) {
				Musica musica = new Musica();
				musica.setId(rs.getInt("idMusica"));
				musica.setTitulo(rs.getString("titulo"));
				musica.setArtista(rs.getString("artista"));
				musica.setAlbum(rs.getString("album"));
				musica.setEstilo(rs.getInt("estilo"));
				musica.setLinkMP3(rs.getString("linKMP3"));
				
				listaMusicas.add(musica);
			}
			return listaMusicas;
		}catch (SQLException e) {
			System.out.println("Erro ao trazer acervo de Músicas"+e.getMessage());
		}
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
