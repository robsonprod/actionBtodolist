package integracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.ConnectionImpl;
import com.mysql.jdbc.ConnectionPropertiesImpl;

import br.todolist.dao.ConnectionFactory;
import br.todolist.dao.TarefaDao;
import br.todolist.model.Tarefa;

public class AdicionaTarefaTest {

	public Connection con;
	public Tarefa tarefa;
	public TarefaDao dao;
	

	@BeforeClass
	public static void initClass() {

	}
	
	@Before
	public void init() {
		con = new ConnectionFactory().getConnection();
	}
	
	@After
	public void clear() {
		
	}
	@Test
	public void deveAdicionarTarefa() throws SQLException {
		Tarefa tarefa = new Tarefa();
		tarefa.setId(new Long(1));
		tarefa.setNome("nome2");
		tarefa.setUser_id(new Long(1));
		tarefa.setDescricao("descricao");
		
		TarefaDao dao = new TarefaDao(con);
		dao.adiciona(tarefa);
		
		try {
			PreparedStatement psBusca = this.con.prepareStatement("SELECT last_insert_id()");
			ResultSet result = psBusca.executeQuery();
			if(result.next()) {
				String valor = result.getString("nome");
				System.out.println(valor);
			}
			psBusca.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deveAdicionarTarefa2() {
		
		Tarefa tarefa = new Tarefa();
		tarefa.setId(new Long(1));
		tarefa.setNome("nome");
		tarefa.setUser_id(new Long(1));
		tarefa.setDescricao("descricao");
		
		
		TarefaDao dao = new TarefaDao(con);
		dao.adiciona(tarefa);
		
	}
	
	
	
	
	
}
