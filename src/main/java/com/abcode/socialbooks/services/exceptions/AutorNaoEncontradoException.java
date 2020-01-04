package com.abcode.socialbooks.services.exceptions;

public class AutorNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 8729297860040609503L;

	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public AutorNaoEncontradoException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

}
