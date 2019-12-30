package com.abcode.socialbooks.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcode.socialbooks.domain.Livro;
import com.abcode.socialbooks.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroResources {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public List<Livro> listar() {
		return livroRepository.findAll();
	}

	@PostMapping
	public void salvar(@RequestBody Livro livro) {
		livroRepository.save(livro);
	}

	@GetMapping("/{id}")
	public Livro buscar(@PathVariable Long id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(null);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		Livro obj = this.buscar(id);
		livroRepository.deleteById(obj.getId());
	}

	@PutMapping("/{id}")
	public void atualizar(@RequestBody Livro livro, @PathVariable("id") Long id) {
		livro.setId(id);
		livroRepository.save(livro);
	}

}
