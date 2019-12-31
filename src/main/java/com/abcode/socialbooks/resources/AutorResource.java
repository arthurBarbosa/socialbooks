package com.abcode.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcode.socialbooks.domain.Autor;
import com.abcode.socialbooks.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorResource {

	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public ResponseEntity<List<Autor>> listar(){
		List<Autor> obj = autorService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
}
