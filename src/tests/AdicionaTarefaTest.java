package tests;

import java.sql.Connection;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.todolist.dao.TarefaDao;
import br.todolist.exception.AdicionaTarefaException;
import br.todolist.manager.AdicionaTarefaLogica;
import br.todolist.manager.PesquisaTarefaLogica;
import br.todolist.model.Tarefa;
import br.todolist.model.Usuario;


public class AdicionaTarefaTest {
	
	AdicionaTarefaLogica addtarefa;
	HttpServletRequest request;
    HttpServletResponse response;
    Connection connect;
    TarefaDao dao;
	Usuario user;
    Tarefa tarefa;
    HttpSession session;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		addtarefa = new AdicionaTarefaLogica();
		tarefa = new Tarefa();
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		session = Mockito.mock(HttpSession.class);
		connect = Mockito.mock(Connection.class);
		dao = Mockito.mock(TarefaDao.class);
		user = Mockito.mock(Usuario.class);
	}

	@Test(expected=AdicionaTarefaException.class)
	public void naoDeveAdicionarTarefaSemNome() throws Exception {	
		//cenario
		
		user.setId(new Long(1));
		user.setCargo(1);
		user.setNomeLogin("admin");
		user.setSenha("123");
		session.setAttribute("userLogado", user);
		
		when(session.getAttribute("userLogado")).thenReturn(user);

		when(request.getParameter("nome")).thenReturn("");
		when(request.getParameter("descricao")).thenReturn("");
		when(request.getParameter("id")).thenReturn(null);
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		dao = new TarefaDao(connect);
		tarefa.setUser_id(new Long(1));
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		
	    when(addtarefa.executa(request, response)).thenThrow(new AdicionaTarefaException("Não é possivel adicionar tarefa com campos em branco!"));
	    
	    //verificacao
	    addtarefa.possuiNomeDescricao(tarefa);
	    addtarefa.executa(request, response);
	}
	
	@Test
	public void adicionaTarefaComSucesso() {
		tarefa = new Tarefa("tarefa1", "descricao1", new Long(1));
		dao.adiciona(tarefa);
		Assert.assertEquals(tarefa.getNome(), "tarefa1");
	}
	
	
}
