package com.restful.falabella.model;

import com.restful.falabella.entity.Comentario;

public class MComentario {
	private long id;
	private String titulo;
	private String contenido;

	public MComentario() {
		
	}
	
	/**
	 * Convierte la entidad al Modelo.
	 * @param comentario
	 */
	public MComentario(Comentario comentario) {
		this.id = comentario.getId();
		this.titulo = comentario.getTitulo();
		this.contenido = comentario.getContenido();
	}

	public MComentario(long id, String titulo, String contenido) {
		this.id = id;
		this.titulo = titulo;
		this.contenido = contenido;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}
	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
