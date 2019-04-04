package com.restful.falabella.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.restful.falabella.entity.Comentario;
import com.restful.falabella.model.MComentario;

@Component("convertidor")
public class Convertidor {
	public List<MComentario> convertirLista(List <Comentario> comentarios) {
		List<MComentario> mcomentarios = new ArrayList<>();
		
		for (Comentario comentario : comentarios) {
			mcomentarios.add(new MComentario(comentario));
		}
		
		return mcomentarios;
	}
}
