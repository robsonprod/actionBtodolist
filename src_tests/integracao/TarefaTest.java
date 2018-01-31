package integracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.todolist.dao.ConnectionFactory;
import br.todolist.dao.TarefaDao;
import br.todolist.exception.TarefaServletException;
import br.todolist.model.Tarefa;

public class TarefaTest{

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
		limparBanco();
	}
	
	@Test
	public void deveAdicionarTarefa(){
		boolean result = false;

		Tarefa tarefa = new Tarefa("tarefa1", "tarefa teste 1", new Long(2));
		TarefaDao dao = new TarefaDao(con);
		dao.adiciona(tarefa);

		result = consultaTarefa();

		Assert.assertTrue(result);
	}
	
	@Test
	public void deveListarTarefa() {
		TarefaDao dao = new TarefaDao(con);
		executeSql("insert into tarefa (nome, descricao, id_usuario) values ('tarefa1', 'descricao tarefa1', 2)");
		executeSql("insert into tarefa (nome, descricao, id_usuario) values ('tarefa2', 'descricao tarefa2', 2)");
		executeSql("insert into tarefa (nome, descricao, id_usuario) values ('tarefa3', 'descricao tarefa3', 2)");
		
		List<Tarefa> lista = dao.getLista(new Long(2));
		
		Assert.assertEquals(3, lista.size());
	}
	
	@Test
	public void deveRemoverTarefa() throws TarefaServletException {
		boolean result = false;
		TarefaDao dao = new TarefaDao(con);
		executeSql("insert into tarefa (nome, descricao, id_usuario) values ('tarefa1', 'descricao tarefa1', 2)");
		Integer idUsuario = 2;
		
		pegaTarefa(idUsuario);
		
		dao.remove(tarefa);
		
		result = consultaTarefa();
		
		Assert.assertFalse(result);
		
	}
	
	@Test
	public void deveAlterarTarefa() {
		TarefaDao dao = new TarefaDao(con);
		executeSql("insert into tarefa (nome, descricao, id_usuario) values ('tarefa1', 'descricao tarefa1', 2)");
		Integer idUsuario = 2;
		
		pegaTarefa(idUsuario);
		
		Assert.assertEquals("tarefa1", "tarefa1", tarefa.getNome());
		
		tarefa.setNome("novaTarefa");
		
		dao.altera(tarefa);
		
		Assert.assertEquals("novaTarefa", tarefa.getNome());
		
	}
	
	@Test
	public void deveRetornarTarefa() {
		TarefaDao dao = new TarefaDao(con);
		executeSql("insert into tarefa (nome, descricao, id_usuario) values ('tarefa1', 'descricao tarefa1', 2)");
		
		Integer idUsuario = 2;
		
		Tarefa tarefa = pegaTarefa(idUsuario);
		
		Tarefa tarefaBuscada = dao.getTarefa(tarefa.getId());
		
		Assert.assertEquals(tarefa.getId(), tarefaBuscada.getId());
	}
	
	private boolean consultaTarefa() {
		boolean result = false;
		try {
			PreparedStatement ps = this.con.prepareStatement("select * from tarefa where id_usuario=?");
			ps.setLong(1, new Long(2));
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				result = true;
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private Tarefa pegaTarefa(Integer idUsuario) {
		try {
			PreparedStatement ps = this.con.prepareStatement("select * from tarefa where id_usuario=?");
			ps.setLong(1, idUsuario);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String id = rs.getString("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				tarefa = new Tarefa();
				tarefa.setId(new Long(id));
				tarefa.setNome(nome);
				tarefa.setDescricao(descricao);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tarefa;
	}
	
	public void executeSql(String sql) {
		try {
			PreparedStatement ps = this.con.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void limparBanco() {
		try {
			PreparedStatement ps = this.con.prepareStatement("delete from tarefa");
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
