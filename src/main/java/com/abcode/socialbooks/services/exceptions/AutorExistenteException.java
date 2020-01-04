package com.abcode.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException{

	private static final long serialVersionUID = -1530446654189036306L; 
	
	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
