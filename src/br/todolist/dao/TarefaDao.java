package br.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.todolist.exception.TarefaServletException;
import br.todolist.model.Tarefa;

public class TarefaDao {

	private Connection connect;
	
	public TarefaDao(Connection connect) {
		this.connect = connect;
	}
	
	public void adiciona(Tarefa tarefa){
		try{
			PreparedStatement ps = this.connect.prepareStatement("insert into tarefa (nome, descricao, id_usuario) values (?, ?, ?)");
			
			ps.setString(1, tarefa.getNome());
			ps.setString(2, tarefa.getDescricao());
			ps.setLong(3, tarefa.getUser_id());
			
			ps.execute();
			ps.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Tarefa> getLista(Long userid){
		try{
			PreparedStatement ps = this.connect.prepareStatement("select * from tarefa where id_usuario=?");
			ps.setLong(1, userid);
			
			List<Tarefa> tarefas = new ArrayList<>();
			Tarefa tarefa = null;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String id = rs.getString("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				
				tarefa = new Tarefa();
				tarefa.setId(new Long(id));
				tarefa.setNome(nome);
				tarefa.setDescricao(descricao);
				
				tarefas.add(tarefa);
			}
			rs.close();
			ps.close();
			return tarefas;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Tarefa tarefa) throws TarefaServletException{
		try{
			PreparedStatement ps = this.connect.prepareStatement("delete from tarefa where id=?");
			
			ps.setLong(1, tarefa.getId());
			
			ps.execute();
			ps.close();
		}catch(SQLException e){
			throw new TarefaServletException(e.getMessage());
		}
	}
	
	public void altera(Tarefa tarefa){
		try{
			PreparedStatement ps = this.connect.prepareStatement("update tarefa set nome=?, descricao=? where id=?");
			
			ps.setString(1, tarefa.getNome());
			ps.setString(2, tarefa.getDescricao());
			ps.setLong(3, tarefa.getId());
			
			ps.execute();
			ps.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Tarefa getTarefa(Long id){
		try{
			PreparedStatement ps = this.connect.prepareStatement("select * from tarefa where id=?");
			ps.setLong(1, id);
			
			Tarefa tarefa = null;
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Long idTarefa = rs.getLong("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				
				tarefa = new Tarefa();
				tarefa.setId(idTarefa);
				tarefa.setNome(nome);
				tarefa.setDescricao(descricao);
				
			}
			rs.close();
			ps.close();
			return tarefa;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Tarefa getTarefaNome(String nomeTarefa){
		try{
			PreparedStatement ps = this.connect.prepareStatement("select * from tarefa where nome like ? ");
			ps.setString(1, nomeTarefa+"%");
			
			Tarefa tarefa = null;
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Long idTarefa = rs.getLong("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				
				tarefa = new Tarefa();
				tarefa.setId(idTarefa);
				tarefa.setNome(nome);
				tarefa.setDescricao(descricao);
				
			}
			rs.close();
			ps.close();
			return tarefa;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
