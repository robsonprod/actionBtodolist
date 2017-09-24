package br.todolist.manager;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.todolist.dao.TarefaDao;
import br.todolist.exception.AdicionaTarefaException;
import br.todolist.model.Logica;
import br.todolist.model.Tarefa;
import br.todolist.model.Usuario;

public class AdicionaTarefaLogica implements Logica{

	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		HttpSession session = request.getSession();
		Usuario user = new Usuario();
		user = (Usuario) session.getAttribute("userLogado");
		
		Connection connect = (Connection) request.getAttribute("connect");
		TarefaDao dao = new TarefaDao(connect);

		Tarefa tarefa = atribuiValores(nome, descricao, user);
		
		if(request.getParameter("id") != null){
			String id = request.getParameter("id");
			tarefa.setId(new Long(id));
			request.setAttribute("msgUsuario", "Tarefa atualizada com sucesso!");
			dao.altera(tarefa);
		}else{
			dao.adiciona(tarefa);
			request.setAttribute("msgUsuario", "Tarefa cadastrada com sucesso!");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/index.jsp");
		rd.forward(request, response);
	}

	private Tarefa atribuiValores(String nome, String descricao, Usuario user) throws AdicionaTarefaException {
		if(nome == null || nome == "") {
			throw new AdicionaTarefaException("Nome invalido");
		}
		
		Tarefa tarefa = new Tarefa();
		tarefa.setUser_id(new Long(user.getId()));
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		return tarefa;	
	}
}
