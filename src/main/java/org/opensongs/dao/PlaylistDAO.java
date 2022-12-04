package org.opensongs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.opensongs.model.Musica;
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
		try {
			String query="SELECT * FROM tblPlaylist WHERE idUsuario=?";
			Integer idUsuario=(Integer) objCriterio;
			
			PreparedStatement stm =dataSource.getConnection().prepareStatement(query);
			stm.setInt(1, idUsuario);
			ResultSet resultSet = stm.executeQuery();
			
			List<Object> playlistList = new ArrayList<>();
			while(resultSet.next()) {
				Playlist playlist = new Playlist();
				playlist.setId(resultSet.getInt("idPlaylist"));
				playlist.setTitulo(resultSet.getString("titulo"));
				playlistList.add(playlist);
			}
			resultSet.close();
			stm.close();
			return playlistList;
			
		}catch(SQLException e) {
			System.out.println("Erro ao recuperar playlists já gravadas "+e.getMessage());
		}
		return null;
	}

	public Playlist readDetailsById(Integer id){
		Playlist playlist = null;
		try {
			
			String query = 
					"select playlists.idPlaylist as idPlaylist,"
					+ "		playlists.idUsuario  as idUsuario,"
					+ "     playlists.titulo     as pl_titulo,"
					+ "     musicas.idMusica     as idMusica,"
					+ "     musicas.titulo       as mus_titulo,"
					+ "     musicas.artista      as artista,"
					+ "     musicas.album        as album,"
					+ "     musicas.estilo       as estilo,"
					+ "     musicas.linkMP3      as linkMP3"
					+ "	from tblPlaylist as playlists"
					+ "		left outer join tblMusicaPlaylist as musicas_playlist on playlists.idPlaylist = musicas_playlist.idPlaylist"
					+ " 	left outer join tblMusica as musicas on musicas_playlist.idMusica = musicas.idMusica"
					+ " where playlists.idPlaylist= ?";
			PreparedStatement stm = dataSource.getConnection().prepareStatement(query);
			stm.setInt(1, id);
			ResultSet resultSet = stm.executeQuery();
			resultSet.next();
			do {
				if(Objects.isNull(playlist)) {					
					playlist = new Playlist();
					playlist.setMusicas(new ArrayList<Musica>());
					playlist.setId(resultSet.getInt("idPlaylist"));
					playlist.setTitulo(resultSet.getString("pl_titulo"));
				}
				
				if (Objects.nonNull(resultSet.getString("mus_titulo"))) {
                    Musica musica = new Musica();
                    musica.setId(resultSet.getInt("idMusica"));
                    musica.setTitulo(resultSet.getString("mus_titulo"));
                    musica.setArtista(resultSet.getString("artista"));
                    musica.setEstilo(resultSet.getInt("estilo"));
                    musica.setAlbum(resultSet.getString("album"));
                    musica.setLinkMP3(resultSet.getString("linkMP3"));
                    playlist.getMusicas().add(musica);
                }
			} while(resultSet.next());
			return playlist;
		}catch(SQLException e) {
			System.out.println("Erro ao obter detalhes da playlist "+e.getMessage());
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
