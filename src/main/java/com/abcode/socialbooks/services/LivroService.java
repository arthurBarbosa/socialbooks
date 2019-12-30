package com.abcode.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.abcode.socialbooks.domain.Livro;
import com.abcode.socialbooks.repository.LivroRepository;
import com.abcode.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> listar(){
		return livroRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Optional<Livro> obj = livroRepository.findById(id);
		if(!obj.isPresent()) {
			throw new LivroNaoEncontradoException("Livro nao encontrado");
		}
		return obj.get();
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livroRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livroRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("Livro nao encontrado.");
		}
	}
	
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livroRepository.save(livro);
	}
	
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
	
}
