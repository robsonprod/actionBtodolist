package tests;

import java.sql.Connection;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.todolist.dao.TarefaDao;
import br.todolist.exception.AdicionaTarefaException;
import br.todolist.manager.AdicionaTarefaLogica;
import br.todolist.manager.PesquisaTarefaLogica;
import br.todolist.model.Tarefa;


public class AdicionaTarefaTest {
	
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@Mock
	private Tarefa tarefa;
	@Mock
	private TarefaDao dao;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void naoDeveAdicionarTarefaSemNome() throws Exception {
		AdicionaTarefaLogica addtarefa = new AdicionaTarefaLogica();
		
		request = Mockito.mock( HttpServletRequest.class);
	    response = Mockito.mock( HttpServletResponse.class);

	    tarefa = new Tarefa();
	    
	    when(request.getParameter("nome")).thenReturn("");

	    addtarefa.executa(request, response);
	    
		//verificacao
	    Assert.assertEquals(tarefa.getNome(), "tarefa1");

	}
	
	@Test
	public void pesquisaTarefa() throws Exception {
		HttpServletRequest request = Mockito.mock( HttpServletRequest.class);
	    HttpServletResponse response = Mockito.mock( HttpServletResponse.class);
	    
	    PesquisaTarefaLogica pTarefa = new PesquisaTarefaLogica();
	    
	    pTarefa.executa(request, response);
	    
	    
	    
	}
	
	
}
