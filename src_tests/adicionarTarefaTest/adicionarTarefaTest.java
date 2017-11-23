package adicionarTarefaTest;

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


public class adicionarTarefaTest {
	
	private AdicionaTarefaLogica addtarefa;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Connection connect;
	private TarefaDao dao;
	private Usuario user;
	private Tarefa tarefa;
	private HttpSession httpSession;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		addtarefa = new AdicionaTarefaLogica();
		tarefa = new Tarefa();
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		connect = Mockito.mock(Connection.class);
		httpSession = Mockito.mock(HttpSession.class);
		dao = new TarefaDao(connect);
		user = new Usuario();
	}

	@Test(expected=AdicionaTarefaException.class)
	public void naoDeveAdicionarTarefaSemNome() throws Exception {	
		//cenario
		
		user.setId(new Long(1));
		user.setCargo(1);
		user.setNomeLogin("admin");
		user.setSenha("123");
		httpSession.setAttribute("userLogado", user);
		user = (Usuario) httpSession.getAttribute("userLogado");
		when(httpSession.getAttribute("userLogado")).thenReturn(user);

		when(request.getParameter("nome")).thenReturn("");
		when(request.getParameter("descricao")).thenReturn("");
		when(request.getParameter("id")).thenReturn("");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		tarefa.setUser_id(new Long(1));
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		
		
		
	    //verificacao
		boolean r = addtarefa.possuiNomeDescricao(tarefa);
		Assert.assertEquals(false, r);
		boolean r2 = addtarefa.executa(request, response);
		Assert.assertEquals(false, r2);
	}
	
	@Test
	public void adicionaTarefaComSucesso() {
		tarefa = new Tarefa("tarefa1", "descricao1", new Long(1));
		dao.adiciona(tarefa);
		Assert.assertEquals(tarefa.getNome(), "tarefa1");
	}
	
//	duvida
	public boolean place() {
		int valor = 0;

		try {
			if(valor == 0) {
				return false;
			}
		}catch(Exception e) {
//			return false;
		}
		return true;
	}
	
	
}

