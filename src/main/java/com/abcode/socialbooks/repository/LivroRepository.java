package com.abcode.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcode.socialbooks.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
