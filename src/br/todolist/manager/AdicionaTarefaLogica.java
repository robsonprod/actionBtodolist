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
	boolean result = false;

	public boolean executa(HttpServletRequest request, HttpServletResponse response) throws Exception, AdicionaTarefaException{
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		HttpSession session = request.getSession();
		Usuario user = new Usuario();
		user = (Usuario) session.getAttribute("userLogado");
		
		Connection connect = (Connection) request.getAttribute("connect");
		TarefaDao dao = new TarefaDao(connect);

		Tarefa tarefa = new Tarefa();
		tarefa.setUser_id(new Long(user.getId()));
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		
		tarefaExistente(request, dao, tarefa);
		
		if(possuiNomeDescricao(tarefa)) {
			dao.adiciona(tarefa);
			request.setAttribute("msgUsuario", "Tarefa cadastrada com sucesso!");
			result = true;
		}else {
			result = false;
			throw new AdicionaTarefaException("Não é possivel adicionar tarefa com campos em branco!");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/index.jsp");
		rd.forward(request, response);
		return result;
	}

	public boolean tarefaExistente(HttpServletRequest request, TarefaDao dao, Tarefa tarefa) throws AdicionaTarefaException {
		if(request.getParameter("id") != null && possuiNomeDescricao(tarefa)){
			String id = request.getParameter("id");
			tarefa.setId(new Long(id));
			request.setAttribute("msgUsuario", "Tarefa atualizada com sucesso!");
			dao.altera(tarefa);
			result = true;
		}else {
			result = false;
		}
		return result;
	}

	public boolean possuiNomeDescricao(Tarefa tarefa) {
		return tarefa.getNome() != null || tarefa.getNome().isEmpty() && tarefa.getDescricao() != null || tarefa.getDescricao().isEmpty();
	}

}
