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

public class PesquisaTarefaLogica implements Logica{

	@Override
	public boolean executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		Usuario user = new Usuario();
		user = (Usuario) session.getAttribute("userLogado");
		
		String nome = request.getParameter("nome");
		Tarefa tarefa = new Tarefa();
		Connection connect = (Connection) request.getAttribute("connect");
		TarefaDao dao = new TarefaDao(connect);

//		tarefa = dao.getTarefaPeloNome(nome);
		System.out.println(tarefa.getUser_id());
		System.out.println(user.getId());
		
		if(tarefa.getUser_id() == user.getId()) {
			request.setAttribute("tarefaNome", tarefa.getNome());
			request.setAttribute("tarefaDescricao", tarefa.getDescricao());
			RequestDispatcher rd = request.getRequestDispatcher("/pages/tarefa.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msgUsuario", "Nenhuma tarefa encontrada!");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/index.jsp");
			rd.forward(request, response);
		}
		
		
		return true;
	}

}
