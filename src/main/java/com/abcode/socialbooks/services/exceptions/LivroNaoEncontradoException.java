package com.abcode.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 2398339527391423007L;

	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
