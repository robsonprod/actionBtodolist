package tests;

import java.sql.Connection;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import br.todolist.model.Usuario;


public class AdicionaTarefaTest {
	
	@Mock
	private Tarefa tarefa;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void naoDeveAdicionarTarefaSemNome() throws Exception {
		//cenario
		AdicionaTarefaLogica addtarefa = Mockito.mock(AdicionaTarefaLogica.class);
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
	    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
	    tarefa = new Tarefa();
	    
	    request.setAttribute("nome", "tarefa1");
	    when(request.getParameter("nome")).thenReturn("tarefa1");
	    
	    
	    
	    //ação
	    System.out.println(request.getParameter("nome"));
	    
	    addtarefa.executa(request, response);
	    
	    //verificacao
	    
	    
	    Assert.assertEquals(tarefa.getNome(), "tarefa1");

	}
	
	
}
