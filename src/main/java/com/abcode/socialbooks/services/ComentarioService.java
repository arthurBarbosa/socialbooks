package com.abcode.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcode.socialbooks.domain.Comentario;
import com.abcode.socialbooks.domain.Livro;
import com.abcode.socialbooks.repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	@Autowired
	private LivroService livroService;

	public Comentario salvar(Long livroId, Comentario comentario) {
		Livro obj = livroService.buscar(livroId);
		comentario.setLivro(obj);
		comentario.setData(new Date());
		return comentarioRepository.save(comentario);
	}

	public List<Comentario> listarComentarios(Long livroId) {
		Livro obj = livroService.buscar(livroId);
		
		return obj.getComentarios();
	}

}
