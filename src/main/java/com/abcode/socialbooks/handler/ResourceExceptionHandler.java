package com.abcode.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abcode.socialbooks.domain.DetalheErro;
import com.abcode.socialbooks.services.exceptions.AutorExistenteException;
import com.abcode.socialbooks.services.exceptions.AutorNaoEncontradoException;
import com.abcode.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalheErro> handleLivroNaoEncontradoException(LivroNaoEncontradoException e,
			HttpServletRequest request) {
		DetalheErro erro = new DetalheErro();
		erro.setStatus(404l);
		erro.setTitulo("Livro nao pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalheErro> handleLivroNaoEncontradoException(AutorExistenteException e,
			HttpServletRequest request) {
		DetalheErro erro = new DetalheErro();
		erro.setStatus(409l);
		erro.setTitulo("Autor ja existente.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<DetalheErro> handleLivroNaoEncontradoException(AutorNaoEncontradoException e,
			HttpServletRequest request) {
		DetalheErro erro = new DetalheErro();
		erro.setStatus(409l);
		erro.setTitulo("Autor nao encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}


}
