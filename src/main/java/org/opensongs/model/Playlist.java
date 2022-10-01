package org.opensongs.model;

import java.io.Serializable;
import java.util.List;

public class Playlist implements Serializable {
	private int id;
	private String titulo;
	private List<Musica> musicas;
	
	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public Playlist() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
