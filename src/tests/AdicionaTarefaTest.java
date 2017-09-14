package tests;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.todolist.dao.TarefaDao;
import br.todolist.dao.TarefaDaoFake;
import br.todolist.manager.AdicionaTarefaLogica;
import br.todolist.model.Tarefa;


public class AdicionaTarefaTest {
	
	@InjectMocks
	private AdicionaTarefaLogica addtarefa;
	
	@Mock
	private Tarefa tarefa;
	@Mock
	private TarefaDao dao;
	@Mock
	private Connection connect;
	@Mock
	AdicionaTarefaLogica addLogica;

	@Before
	public void setup(){
		dao = Mockito.mock(TarefaDao.class);
		tarefa = Mockito.mock(Tarefa.class);
		addLogica = Mockito.mock(AdicionaTarefaLogica.class);
	}

	@Test
	public void naoDeveAdicionarComCampoNull() throws Exception {
		//cenario
		tarefa.setDescricao("asadasdasd");
		tarefa.setId(1l);
		tarefa.setNome("tarefa 1");
		tarefa.setUser_id(1l);
		
		HttpServletRequest request = Mockito.mock( HttpServletRequest.class );
	    HttpServletResponse response = Mockito.mock( HttpServletResponse.class);

	    addtarefa.executa(request, response);
	    request.getAttribute("descricao");
	    request.getAttribute("nome");
	    
		//acao
		dao = new TarefaDao(connect);
	    dao.adiciona(tarefa);
		
		//verificacao
//	    Assert.assertEquals(tarefa.getNome(), "tarefa 1");
	    Assert.assertEquals("tarefa 1", tarefa.getNome());
	    Assert.assertEquals("tarefa 1", tarefa.getNome());
	}

}
