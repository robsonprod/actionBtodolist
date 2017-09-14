package br.todolist.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.todolist.exception.TarefaServletException;
import br.todolist.model.Logica;

@WebServlet("/pages/sistema")
public class ServletSistema extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crud = request.getParameter("logica");
		String nomeClasse = "br.todolist.manager."+crud+"Logica";
//		pegando classe pelo nome
		try {
			Class classe = Class.forName(nomeClasse);
			Object objeto = classe.newInstance();
//			polimorfismo
			Logica logica = (Logica) objeto;
			logica.executa(request, response);
		} catch (ClassNotFoundException e) {
			throw new TarefaServletException(e.getMessage());
		} catch (InstantiationException e) {
			throw new TarefaServletException(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new TarefaServletException(e.getMessage());
		} catch (Exception e) {
			throw new TarefaServletException(e.getMessage());
		}

	}

}
