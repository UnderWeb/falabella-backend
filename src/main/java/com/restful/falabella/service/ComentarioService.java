package com.restful.falabella.service;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.restful.falabella.converter.Convertidor;
import com.restful.falabella.entity.Comentario;
import com.restful.falabella.model.MComentario;
import com.restful.falabella.repository.ComentarioRepositorio;

@Service("servicio")
public class ComentarioService {
	@Autowired
	@Qualifier("repositorio")
	private ComentarioRepositorio repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	// Log
	private static final Log logger = LogFactory.getLog(ComentarioService.class);

	/**
	 * Obtiene todos los comentarios.
	 * @return Lista de comentarios.
	 */
	public List<MComentario> obtener() {
		return convertidor.convertirLista(repositorio.findAll());
	}

	/**
	 * Obtiene un comentario específico.
	 * @param id identificador del comentario.
	 * @return Objeto Comentario.
	 */
	public MComentario getById(long id) {
		try {
			Comentario comentario = repositorio.findById(id);
			
			if (comentario == null) {
				logger.error("El comentario con identificador " + id + " no se encuentra registrado.");
	            return null;
	        }
			
			return new MComentario(repositorio.findById(id));
		} catch (Exception ex) {
			logger.error("Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Ingresa un nuevo comentario.
	 * @param comentario Objeto Comentario.
	 * @return
	 */
	public Comentario crear(Comentario comentario) {
		try {
			return repositorio.save(comentario);
			//return true;
		} catch (Exception ex) {
			logger.error("Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Actualiza un comentario específico.
	 * @param comentario Objeto comentario.
	 * @param id identificador del comentario.
	 * @return Objeto comentario.
	 */
	public Comentario actualizar(Comentario comentario, long id) {
		try {
			Comentario comentary = repositorio.findById(id);
			
			if (comentary == null) {
				logger.error("El comentario con id " + id + " no se encuentra registrado.");
	            return null;
	        }

			comentary.setTitulo(comentario.getTitulo());
			comentary.setContenido(comentario.getContenido());

			return repositorio.save(comentary);
		} catch (Exception ex) {
			logger.error("Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Elimina un comentario específico.
	 * @param id identificador del comentario.
	 * @return Borrado correcto o incorrecto del comentario.
	 */
	public boolean borrar(long id) {
		try {
			Comentario comentario = repositorio.findById(id);
			repositorio.delete(comentario);
			return true;
		} catch (Exception ex) {
			logger.error("Error: " + ex.getMessage());
			return false;
		}
	}
}
