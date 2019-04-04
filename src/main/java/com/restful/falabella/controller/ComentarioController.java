package com.restful.falabella.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.falabella.entity.Comentario;
import com.restful.falabella.model.MComentario;
import com.restful.falabella.service.ComentarioService;

@RestController
@RequestMapping("api")
public class ComentarioController {

	@GetMapping("/comentarios")
	public List<MComentario> obtenerComentarios() {
		return service.obtener();
	}
	
	@GetMapping("/comentario/{id}")
	public MComentario obtenerComentario(@PathVariable("id") long id) {
		return service.getById(id);
	}

	@Autowired
	@Qualifier("servicio")
	ComentarioService service;

	@PostMapping("/comentario")
	public Comentario agregar(@Valid Comentario comentario) {
		return service.crear(comentario);
	}
	
	@PutMapping("/comentario/{id}")
	public Comentario actualizar(@Valid Comentario comentario, @PathVariable("id") long id) {
		return service.actualizar(comentario, id);
	}
	
	@DeleteMapping("/comentario/{id}")
	public boolean eliminar(@PathVariable("id") long id) {
		return service.borrar(id);
	}
}
