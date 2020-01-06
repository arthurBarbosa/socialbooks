package com.abcode.socialbooks.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abcode.socialbooks.domain.Autor;
import com.abcode.socialbooks.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorResource {

	@Autowired
	private AutorService autorService;

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Autor>> listar() {
		List<Autor> obj = autorService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Autor autor) {
		autor = autorService.salvar(autor);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Autor>> buscar(@PathVariable("id") Long id) {
		Optional<Autor> autor = autorService.buscar(id);
		
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(autor);
	}
}
