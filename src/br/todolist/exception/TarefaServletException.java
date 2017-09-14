package br.todolist.exception;

import javax.servlet.ServletException;

public class TarefaServletException extends ServletException{

	private static final long serialVersionUID = 1L;
	
	public TarefaServletException(String msg){
		super(msg);
	}
	public TarefaServletException(){
		
	}

}
