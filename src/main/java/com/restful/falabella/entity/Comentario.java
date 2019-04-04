package com.restful.falabella.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="COMENTARIOS")
@Entity
public class Comentario implements Serializable {
	@GeneratedValue
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="CONTENIDO")
	private String contenido;

	/**
	 * Constructor vacío.
	 */
	public Comentario() {
		//
	}

	public Comentario(long id, String titulo, String contenido) {
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
