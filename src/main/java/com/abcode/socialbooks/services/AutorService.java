package com.abcode.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcode.socialbooks.domain.Autor;
import com.abcode.socialbooks.repository.AutorRepository;
import com.abcode.socialbooks.services.exceptions.AutorExistenteException;
import com.abcode.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	public List<Autor> listar() {
		return autorRepository.findAll();
	}

	public Autor salvar(Autor autor) {
		if (autor.getId() != null) {
			Optional<Autor> a = autorRepository.findById(autor.getId());

			if (a != null) {
				throw new AutorExistenteException("O autor ja existe");
			}
		}
		return autorRepository.save(autor);
	}

	public Optional<Autor> buscar(Long id) {

		Optional<Autor> autor = autorRepository.findById(id);

		if (!autor.isPresent()) {
			throw new AutorNaoEncontradoException("O autor nao foi encontrado");
		}

		return autor;
	}

}














