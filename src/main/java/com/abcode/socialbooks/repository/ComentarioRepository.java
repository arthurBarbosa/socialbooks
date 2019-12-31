package com.abcode.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcode.socialbooks.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}
