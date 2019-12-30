package com.abcode.socialbooks.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroResources {

	@GetMapping
	public String listar() {
		return "Rest aplicado, Git passo a passo";
	}

}
