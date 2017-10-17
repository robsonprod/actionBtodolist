package br.todolist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {

	boolean executa(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
