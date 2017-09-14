package br.todolist.manager;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.todolist.dao.TarefaDao;
import br.todolist.model.Logica;
import br.todolist.model.Tarefa;

public class RemoveTarefaLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		Tarefa tarefa = new Tarefa();
		Connection connect = (Connection) request.getAttribute("connect");
		TarefaDao dao = new TarefaDao(connect);
		
		tarefa.setId(new Long(id));
		
		dao.remove(tarefa);
		request.setAttribute("msgUsuario", "Contato removido");
		RequestDispatcher rd = request.getRequestDispatcher("/pages/index.jsp");
		rd.forward(request, response);
		
	}

}