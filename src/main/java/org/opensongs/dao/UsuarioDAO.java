package org.opensongs.dao;

import java.util.ArrayList;
import java.util.List;

import org.opensongs.model.Musica;
import org.opensongs.model.Playlist;
import org.opensongs.model.Usuario;

public class UsuarioDAO implements GenericDAO{
	@Override
	public void create(Object objeto) {}
	
	@Override
	public List<Object> read(Object objCriterio) {//faz algum select
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Jonas");
		usuario.setEmail("jonas@email.com");
		usuario.setPass("1234");
		
		List<Playlist> playlists = new ArrayList<>();
		Playlist lista1 = new Playlist();
		lista1.setId(1);
		lista1.setTitulo("Rock Classics");
		
		List<Musica> musicaPlaylist1 = new ArrayList<>();
		Musica musica1= new Musica();
		musica1.setId(1);
		musica1.setTitulo("Don't cry");
		musica1.setArtista("Guns n' Roses");
		musica1.setAlbum("Don't cry");
		musica1.setEstilo(1);
		musica1.setLinkMP3("musicas/guns-n-roses_dont-cry.mp3");
		Musica musica2= new Musica();
		musica2.setId(2);
		musica2.setTitulo("Out Go the lights");
		musica2.setArtista("Aerosmith");
		musica2.setAlbum("Music from another dimension");
		musica2.setEstilo(1);
		musica2.setLinkMP3("musicas/aerosmith_out-go-the-lights.mp3");
		
		musicaPlaylist1.add(musica2);
		musicaPlaylist1.add(musica1);
		lista1.setMusicas(musicaPlaylist1);
		playlists.add(lista1);
		usuario.setPlaylists(playlists);
		
		List<Object> resultado = new ArrayList<>();
		resultado.add(usuario);
		
 		return resultado;
	}
	
	@Override
	public void update(Object objeto) {}
	
	@Override
	public void delete(Object objeto) {}
}
