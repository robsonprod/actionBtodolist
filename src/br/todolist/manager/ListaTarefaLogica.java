package br.todolist.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.todolist.dao.TarefaDao;
import br.todolist.model.Logica;
import br.todolist.model.Tarefa;
import br.todolist.model.Usuario;

public class ListaTarefaLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connect = (Connection) request.getAttribute("connect");
		List<Tarefa> tarefas = new ArrayList<>();
		TarefaDao dao = new TarefaDao(connect);
		
		Usuario user = new Usuario();
		HttpSession session = request.getSession();
		user = (Usuario) session.getAttribute("userLogado");

		tarefas = dao.getLista(user.getId());

		request.setAttribute("tarefas", tarefas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/listar-tarefas.jsp");
		rd.forward(request, response);
	}

}
