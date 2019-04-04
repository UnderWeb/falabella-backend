package com.restful.falabella.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.restful.falabella.entity.Comentario;;

@Repository("repositorio")
public interface ComentarioRepositorio extends JpaRepository<Comentario, Serializable> {
	public abstract Comentario findById(long id);
}
