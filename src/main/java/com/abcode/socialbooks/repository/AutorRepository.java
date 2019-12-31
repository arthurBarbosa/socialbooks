package com.abcode.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcode.socialbooks.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
